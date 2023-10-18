package com.roadhub.demonio.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Compra extends EntityId implements OperacaoFinanceira{
    @Column(name = "dt_compra")
    private LocalDate dateCompra;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @Column(name = "observacao")
    private String observacao;
    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itens = new ArrayList<>();

    public LocalDate getDateCompra() {
        return dateCompra;
    }

    public void setDateCompra(LocalDate dateCompra) {
        this.dateCompra = dateCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }

    public void addItemCompra(ItemCompra item){
        item.setCompra(this);
        this.itens.add(item);
    }


    @Override
    public String toString() {
        return "Compra{" +
                "dateCompra=" + dateCompra +
                ", fornecedor=" + fornecedor +
                ", observacao='" + observacao + '\'' +
                ", itens=" + itens +
                '}';
    }

    @Override
    public LocalDate getDataOperacao() {
        return this.getDateCompra();
    }

    @Override
    public Double getValorTotalOperacao() {
        return this.getItens().stream()
                .mapToDouble(ItemCompra::getValorCalculado)
                .sum();
    }

    @Override
    public TipoOperacao getTipoOperacao() {
        return TipoOperacao.DEBITO;
    }
}
