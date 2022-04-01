package dive.tech.projeto.aula2.controller;

import dive.tech.projeto.aula2.entity.Produto;
import dive.tech.projeto.aula2.entity.Usuario;
import dive.tech.projeto.aula2.entity.UsuarioConsulta;
import org.apache.commons.lang3.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/usuario")
public class UsuarioController {

    // Slide 8
    @GET
    @Path("/simples/{id}")
    @Produces("application/json")
    public String filtrarUsuarios(@PathParam("id") Long id,
                                  @QueryParam("nome") String nome,
                                  @QueryParam("saldo")
                                  @Min(value = 0, message = "O valor mínimo do saldo é zero!")
                                  @Max(value = 1000, message = "O valor máximo do saldo é 1000!") BigDecimal saldo) {
        return "ID: " + id + ",\n" +
                "Nome: " + nome + ",\n" +
                "Saldo: " + saldo + "\n";
    }

    // Slide 9
    @GET
    @Path("/objeto")
    @Consumes("application/json")
    @Produces("application/json")
    public String filtrarUsuarios(@Valid UsuarioConsulta usuarioConsulta) {
        return usuarioConsulta.toString();
    }

    // Slides 10 até 19
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void criarNovoUsuario(Usuario usuario) {
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Data de nascimento: " + usuario.getDataNascimento());

        for (Produto produto : usuario.getProdutos()) {
            System.out.println("Nome do produto: " + produto.getNome());
            System.out.println("Valor do produto: " + produto.getValor());
        }

        // Fingir que estamos salvando no banco de dados...
        // Fingido com sucesso.

        System.out.println("Salvo com sucesso!");
    }

    // Slide 20
    @GET
    @Produces("application/json")
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = criarListaDeUsuarios();

        return usuarios;
    }

    // Slide 21
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response buscarUsuarioPorId(@PathParam("id") Long id) {
        List<Usuario> usuarios = criarListaDeUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return Response
                        .ok(usuario)
                        .build();
            }
        }

        return Response
                .noContent()
                .build();
    }

    // Slide 22 e 23
    @GET
    @Path("{id}/produto")
    @Produces("application/json")
    public Response buscarProdutosDoUsuarioPorIdUsuario(@PathParam("id") Long id,
                                                        @QueryParam("nome") String nomeProduto,
                                                        @QueryParam("valor")
                                                        @Min(value = 0, message = "O valor mínimo é zero!")
                                                        @Max(value = 10, message = "O valor máximo é 10!") BigDecimal valor) {
        List<Usuario> usuarios = criarListaDeUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                List<Produto> produtos = usuario.getProdutos();
                List<Produto> produtosFiltrados = new ArrayList<>(produtos);

                for (Produto produto : produtos) {
                    if (!StringUtils.isBlank(nomeProduto) && !produto.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                        produtosFiltrados.remove(produto);
                    }

                    if (valor != null && !produto.getValor().equals(valor)) {
                        produtosFiltrados.remove(produto);
                    }
                }

                return Response
                        .ok(produtosFiltrados)
                        .build();
            }
        }

        return Response
                .noContent()
                .build();
    }

    // Slide 24
    @GET
    @Path("{id}/produto/{idProduto}")
    @Produces("application/json")
    public Response buscarProdutoDoUsuarioPorIdUsuarioEIdProduto(@PathParam("id") Long idUsuario, @PathParam("idProduto") Long idProduto) {
        List<Usuario> usuarios = criarListaDeUsuarios();

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(idUsuario)) {
                for (Produto produto : usuario.getProdutos()) {
                    if (produto.getId().equals(idProduto)) {
                        return Response
                                .ok(produto)
                                .build();
                    }
                }
            }
        }

        return Response
                .noContent()
                .build();
    }

    private List<Usuario> criarListaDeUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNome("Usuário Um da Silva");
        usuario1.setDataNascimento("2021-01-01");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNome("Usuário Dois da Silva");
        usuario2.setDataNascimento("1990-12-30");

        Usuario usuario3 = new Usuario();
        usuario3.setId(3L);
        usuario3.setNome("Usuário Três da Silva");
        usuario3.setDataNascimento("1994-06-17");

        Produto produto1 = new Produto();
        produto1.setId(50153L);
        produto1.setNome("Produto Um");
        produto1.setValor(BigDecimal.TEN);

        Produto produto2 = new Produto();
        produto2.setId(50154L);
        produto2.setNome("Produto Dois");
        produto2.setValor(BigDecimal.ONE);

        usuario1.getProdutos().add(produto1);
        usuario2.getProdutos().add(produto2);
        usuario3.getProdutos().add(produto1);
        usuario3.getProdutos().add(produto2);

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
    }
}