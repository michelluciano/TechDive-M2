package com.senai.bibliotecajsf.repository;


import com.senai.bibliotecajsf.model.Livro;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Representa um mock de repositório (banco de dados fake)
 * com dados persistentes
 */
@ApplicationScoped
public class LivroRepo {

    private List<Livro> livros = new ArrayList<>();
    private long idAtual = 0;

    public LivroRepo() {
        livros.add(new Livro(obterProximoId(), 9788599296578L, "O guia do mochileiro das galáxias", "Douglas Adams", "Ficção",
                LocalDate.of(2011, Month.NOVEMBER, 3), 208));
        livros.add(new Livro(obterProximoId(), 9788531406737L, "Princípios Matemáticos de Filosofia Natural", "Isaac Newton", "Educacional",
                LocalDate.of(1687, Month.JULY, 5), 328));
        livros.add(new Livro(obterProximoId(), 9786555980004L, "O Retrato de Dorian Gray", " Oscar Wilde", "Romance",
                LocalDate.of(1890, Month.DECEMBER, 1), 320));
    }

    public List<Livro> obterLivros() {
        return livros;
    }

    public void adicionar(Livro livroNovo) {
        Long proxId = obterProximoId();
        livroNovo.setId(proxId);
        livros.add(livroNovo);
    }

    public void remover(long idLivro) {
        livros.removeIf(l -> l.getId() == idLivro);
    }

    public void alterar(Livro livroAtualizado) {
        remover(livroAtualizado.getId());
        livros.add(livroAtualizado);
        Collections.sort(livros, Comparator.comparing(Livro::getId));
    }

    private long obterProximoId() {
        return ++idAtual;
    }

}
