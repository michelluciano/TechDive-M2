package dive.tech.projeto.aula3.controller;

import dive.tech.projeto.aula3.entity.Escola;
import dive.tech.projeto.aula3.service.EscolaService;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/escola")
public class EscolaController {

    private final EscolaService escolaService = new EscolaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Escola> consultarEscolas() {
        return escolaService.consultarEscolas();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarEscola(@FormParam("nome") String nome,
                                    @FormParam("turmas") List<Long> idsTurma) {
        try {
            Escola escolaCadastrada = escolaService.cadastrarEscola(nome, idsTurma);
            return Response
                    .ok(escolaCadastrada)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
