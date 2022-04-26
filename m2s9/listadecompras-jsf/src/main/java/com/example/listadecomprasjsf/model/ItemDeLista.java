package com.example.listadecomprasjsf.model;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemDeLista {

    @NotEmpty(message="{campo.obrigatorio}")
    private String descricao;

    private Float quantidade;

    private String medida;

    public ItemDeLista() {
    }

    public ItemDeLista(String descricao, Float quantidade, String medida) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    @Override
    public String toString() {
        return "ItemDeLista{" +
                "descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", medida='" + medida + '\'' +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
