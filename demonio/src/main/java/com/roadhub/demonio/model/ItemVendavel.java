package com.roadhub.demonio.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_item")
public class ItemVendavel extends EntityId{
    @Column(name = "descricao", nullable = true)
    private String descricao;
    @Column(name = "valor_unitario", nullable = true)
    private Double valorUnitario;
    @Column(name = "estocavel", nullable = true)
    private Boolean estocavel;

    public ItemVendavel(Produto produto, double v, double v1, double v2) {
        super();
    }

    public ItemVendavel(Servico servico, double v, double v1, double v2) {
        super();
    }

    public ItemVendavel() {
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Boolean getEstocavel() {
        return estocavel;
    }

    public void setEstocavel(Boolean estocavel) {
        this.estocavel = estocavel;
    }

    @Override
    public String toString() {
        return "ItemVendavel{" +
                "descricao='" + descricao + '\'' +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
