package com.roadhub.demonio.service;

import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.model.QProduto;
import com.roadhub.demonio.model.Status;
import com.roadhub.demonio.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Produto salvar(Produto entity) {
        return repository.save(entity);
    }


    public List<Produto> buscaTodos() {
        return repository.findAll();
    }


    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Produto alterar(Long id, Produto entity) {
        Optional<Produto> existingProdutoOptional = repository.findById(id);
        if(existingProdutoOptional.isEmpty()){
            throw new NotFoundException("Produto não encontrado");
        }

        Produto existingProduto = existingProdutoOptional.get();

        /**existingProduto.setNome(entity.getNome());
        existingProduto.setEstocavel(entity.getEstocavel());
        existingProduto.setStatus((entity.getStatus()));
        existingProduto.setPrecoCompra(entity.getPrecoCompra());
        existingProduto.setDataValidade(entity.getDataValidade());
        existingProduto.setDescricao(entity.getDescricao());
        existingProduto.setValorUnitario(entity.getValorUnitario());**/

        modelMapper.map(entity, existingProduto);

        return repository.save(existingProduto);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}
