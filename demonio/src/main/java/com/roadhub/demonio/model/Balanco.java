package com.roadhub.demonio.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanco extends EntityId{
    private LocalDate dataBalanco;
    private String reponsavel;

    private List<OperacaoFinanceira> operacoes = new ArrayList<>();

    public void addOperacoes(OperacaoFinanceira operacoes){
        this.operacoes.add(operacoes);
    }

    public void delOperacoes(OperacaoFinanceira operacoes){
        this.operacoes.remove(operacoes);
    }

    public LocalDate getDataBalanco() {
        return dataBalanco;
    }

    public void setDataBalanco(LocalDate dataBalanco) {
        this.dataBalanco = dataBalanco;
    }

    public String getReponsavel() {
        return reponsavel;
    }

    public void setReponsavel(String reponsavel) {
        this.reponsavel = reponsavel;
    }

    public List<OperacaoFinanceira> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<OperacaoFinanceira> operacoes) {
        this.operacoes = operacoes;
    }

    public Double getValorTotal(TipoOperacao tipo){
        return this.getOperacoes().stream().filter(op -> op.getTipoOperacao().equals(tipo))
                .mapToDouble(OperacaoFinanceira::getValorTotalOperacao)
                .sum();
    }

    public String getTipoOperacao(OperacaoFinanceira operacao){
        if(operacao instanceof Compra){
            return "Compra";
        }
        if(operacao instanceof Venda){
            return "Venda";
        }

        return "Locação";
    }

    public void imprimirBalanco(){
        System.out.println("----------------------------------------");
        System.out.println("Banlanço número: "+this.getId());
        System.out.println("Data: "+this.getDataBalanco());
        System.out.println("Responsavel: "+this.getReponsavel());
        System.out.println("-----------------------------------------");
        System.out.println("Itens: ");
        for(OperacaoFinanceira op : this.getOperacoes()){
            System.out.println("Data operação: "+op.getDataOperacao() +
                    " Tipo operação: "+op.getTipoOperacao() +
                    " Valor operação: "+op.getValorTotalOperacao()+
                    " - ("+getTipoOperacao(op)+")");
        }
        System.out.println("------------------------------------");
        System.out.println("Total Debito: "+ this.getValorTotal(TipoOperacao.DEBITO));
        System.out.println("Total Credito: "+ this.getValorTotal(TipoOperacao.CREDITO));
        System.out.println("Novo Balanço: "+ (this.getValorTotal(TipoOperacao.CREDITO) - this.getValorTotal(TipoOperacao.DEBITO)));
    }



    @Override
    public String toString() {
        return "Balanco{" +
                "dataBalanco=" + dataBalanco +
                ", reponsavel='" + reponsavel + '\'' +
                '}';
    }
}
