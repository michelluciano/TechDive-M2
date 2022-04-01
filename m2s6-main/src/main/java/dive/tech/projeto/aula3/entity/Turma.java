package dive.tech.projeto.aula3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {

    /*
    Isso faz parte da serialização/desserialização da classe Turma.
    Ou seja: O sistema automaticamente pega os dados do request (requisição),
    cria um objeto do tipo Turma e coloca os dados dentro dele.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private List<Estudante> estudantes = new ArrayList<>();

    public Turma(int j) {
        this.id = (long) j;
        this.nome = "Turma " + j;
    }

    public Turma(Long id) {
        this.id = id;
        this.nome = "Turma " + id;
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

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
}
