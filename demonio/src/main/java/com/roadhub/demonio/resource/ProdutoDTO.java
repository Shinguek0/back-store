package com.roadhub.demonio.resource;

import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDTO {
    private Long id;
    private String name;
    private String descricao;
    private Status status;

    public static ProdutoDTO fromEntity(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setName(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setStatus(produto.getStatus());
        return dto;
    }

    public Produto toEntity(){
        Produto produto = new Produto();
        produto.setId(this.getId());
        produto.setNome(this.getName());
        produto.setDescricao(this.getDescricao());
        produto.setStatus(this.getStatus());
        return produto;
    }

    public static  List<ProdutoDTO> fromEntity(List<Produto> produtos) {
        return produtos.stream().map(produto -> fromEntity(produto)).collect(Collectors.toList());
    }

    public static Page<ProdutoDTO> fromEntity(Page<Produto> produtos){
        List<ProdutoDTO> produtoFind = produtos.stream().map(produto -> fromEntity(produto)).collect(Collectors.toList());
        Page<ProdutoDTO> produtoDTO = new PageImpl<>(produtoFind, produtos.getPageable(), produtos.getTotalElements());
        return produtoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
