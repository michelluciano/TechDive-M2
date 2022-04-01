package dive.tech.projeto.aula2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    /*
    Isso faz parte da serialização/desserialização da classe Usuario.
    Ou seja: O sistema automaticamente pega os dados do request (requisição),
    cria um objeto do tipo Usuario e coloca os dados dentro dele.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String dataNascimento;

    private List<Produto> produtos = new ArrayList<>();

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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

