package dive.tech.projeto.aula3.entity;

import java.io.Serializable;

public class Estudante implements Serializable {

    /*
    Isso faz parte da serialização/desserialização da classe Estudante.
    Ou seja: O sistema automaticamente pega os dados do request (requisição),
    cria um objeto do tipo Estudante e coloca os dados dentro dele.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    public Estudante(String nomeTurma, int k) {
        this.id = (long) k;
        this.nome = "Estudante " + k + " da " + nomeTurma.toLowerCase();
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
}
