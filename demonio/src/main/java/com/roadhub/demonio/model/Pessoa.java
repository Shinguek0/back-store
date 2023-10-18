package com.roadhub.demonio.model;

public abstract class Pessoa extends EntityId{
    private String nome;
    private String telefone;
    private String enderecao;
    private String email;

    public abstract String getDocumentoPrincipal();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnderecao() {
        return enderecao;
    }

    public void setEnderecao(String enderecao) {
        this.enderecao = enderecao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
