package dive.tech.projeto.aula1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.stream.Collectors;

@Path("/hello-world")
public class HelloWorldController {

    // Slide 8 e 19
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!\n";
    }

    // Slide 9
    @POST
    @Consumes("text/plain")
    public String hello(String nome) {
        return "Hello, " + nome + "!\n";
    }

    // Slide 10
    @PUT
    @Consumes("text/plain")
    public String alterarNome(String nomeParaAlterar) {
        String nome = "Fulano";

        String resposta = "Nome anterior: " + nome + "\n";

        nome = nomeParaAlterar;

        resposta += "Nome atual: " + nome;

        return resposta;
    }

    // Slide 11
    @DELETE
    @Path("{id}")
    @Consumes("text/plain")
    public String deletarUsuario(@PathParam("id") Integer id) {
        return "Deletei o usuário de ID " + id + "!\n";
    }

    // Slide 14
    @POST
    @Path("/form-urlencoded")
    @Consumes("application/x-www-form-urlencoded")
    public String postarDadosUrlEncoded(@Context HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());
    }

    // Slide 15
    @POST
    @Path("/form-data")
    @Consumes("multipart/form-data")
    public String postarDadosFormData(@Context HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());
    }

    // Slide 20
    @GET
    @Path("/erro")
    @Produces("text/plain")
    public String erro() throws Exception {
        throw new Exception("Erro!");
    }

    // Slide 21
    @GET
    @Path("/antigo")
    @Produces("text/plain")
    public Response antigo() {
        return Response
                .temporaryRedirect(URI.create("/hello-world/novo"))
                .build();
    }

    // Slide 21
    @GET
    @Path("/novo")
    @Produces("text/plain")
    public String novo() {
        return "Oi! Sou uma URL nova!\n";
    }

    // Slide 22
    @GET
    @Path("/cabecalho")
    @Produces("text/plain")
    public String exibirHeaders(@Context HttpHeaders headers) {
        String resposta = "";

        for (String nomeHeader : headers.getRequestHeaders().keySet()) {
            String valor = headers.getRequestHeaders().getFirst(nomeHeader);
            resposta += nomeHeader + ": " + valor + "\n";
        }

        return resposta;
    }

    // Slide 26 e 27
    @POST
    @Path("/cookie")
    @Consumes("text/plain")
    @Produces("text/plain")
    public Response cookies(String valorCookie) {
        NewCookie cookie = new NewCookie("meuCookie", valorCookie);
        return Response.ok("Criei o cookie \"meuCookie\" com o valor \"" + valorCookie + "\"!")
                .cookie(cookie)
                .build();
    }

    // Slide 27
    @GET
    @Path("/cookie")
    @Produces("text/plain")
    public String cookie(@HeaderParam("Cookie") String cookies) {
        return "Cookies encontrados:\n" + cookies;
    }
}