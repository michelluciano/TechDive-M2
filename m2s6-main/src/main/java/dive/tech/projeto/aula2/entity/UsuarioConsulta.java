package dive.tech.projeto.aula2.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioConsulta implements Serializable {

    /*
    Isso faz parte da serialização/desserialização da classe UsuarioConsulta.
    Ou seja: O sistema automaticamente pega os dados do request (requisição),
    cria um objeto do tipo UsuarioConsulta e coloca os dados dentro dele.
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @Size(min = 3, max = 32, message = "O tamanho do nome precisa ter entre 3 e 32 caracteres!")
    private String nome;

    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", message = "A data precisa ser válida e estar no formato YYYY-MM-DD!")
    private String dataNascimento;

    private List<ProdutoConsulta> produtos = new ArrayList<>();

    @Override
    public String toString() {
        return "{\n" +
                "    ID = " + id + ",\n" +
                "    Nome = " + nome + ",\n" +
                "    Data de nascimento = " + dataNascimento + ",\n" +
                "    Produtos = " + produtos + "\n" +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ProdutoConsulta> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoConsulta> produtos) {
        this.produtos = produtos;
    }
}

