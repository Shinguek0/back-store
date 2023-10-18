package com.roadhub.demonio.service;

import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.model.QProduto;
import com.roadhub.demonio.model.Status;
import com.roadhub.demonio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public Produto salvar(Produto entity) {
        return repository.save(entity);
    }


    public List<Produto> buscaTodos() {
        return repository.findAll();
    }


    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Produto alterar(Produto entity) {
        return repository.save(entity);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}
