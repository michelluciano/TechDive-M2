package dive.tech.projeto.aula3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Escola implements Serializable {

    /*
    Isso faz parte da serialização/desserialização da classe Escola.
    Ou seja: O sistema automaticamente pega os dados do request (requisição),
    cria um objeto do tipo Escola e coloca os dados dentro dele.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private List<Turma> turmas = new ArrayList<>();

    public Escola(int i) {
        this.id = (long) i;
        this.nome = "Escola " + i;
    }

    public Escola(String nome) {
        this.nome = nome;
    }

    public Escola(String nome, List<Turma> turmas) {
        this.nome = nome;
        this.turmas = turmas;
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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
