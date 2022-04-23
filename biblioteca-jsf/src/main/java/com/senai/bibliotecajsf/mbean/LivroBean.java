package com.senai.bibliotecajsf.mbean;

import com.senai.bibliotecajsf.model.Livro;
import com.senai.bibliotecajsf.repository.LivroRepo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class LivroBean implements Serializable {

    @Inject
    private LivroRepo livroRepo;

    private List<Livro> livros = new ArrayList<>();

    @PostConstruct
    public void carregarLivrosJaCadastrados() {
        List<Livro> livrosBD = livroRepo.obterLivros();
        livros.addAll(livrosBD);
    }


    public List<Livro> getLivros() {
        return livros;
    }
}
