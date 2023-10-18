package com.roadhub.demonio.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("servico")
public class Servico extends ItemVendavel {
    //private String descricao; pega do pai
    @Column(name = "qtde_horas", nullable = true)
    private Double quantidadeHoras;

    //private Double valor; pega do pai

    //public Servico(String descricao, Double quantidadeHoras, Double valor) {
    //    super.setDescricao(descricao);
    //    this.quantidadeHoras = quantidadeHoras;
    //    super.setValorUnitario(valor);
    //}

    public Servico(String descricao, Double quantidadeHoras, Double valor) {
            super.setDescricao(descricao);
            this.quantidadeHoras = quantidadeHoras;
            super.setValorUnitario(valor);
    }

    public Servico() {

    }

//    public String getDescricao() {
//         mreturn descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }

    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

//    public Double getValor() {
//        return valor;
//    }
//
//    public void setValor(Double valor) {
//        this.valor = valor;
//    }


    @Override
    public Boolean getEstocavel() {
        return false;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + super.getDescricao() + '\'' +
                ", quantidadeHoras=" + quantidadeHoras +
                ", valor=" + super.getValorUnitario() +
                '}';
    }
}
