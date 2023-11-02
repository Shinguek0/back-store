package com.roadhub.demonio.resource;

import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.service.NotFoundException;
import com.roadhub.demonio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends AbstractController{
    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Produto entity){
        Produto save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produtos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){

        Page<Produto> produtos = service.buscaTodos(filter, PageRequest.of(page, size));
        //List<Produto> produtos = service.buscaTodos(filter);
        //List<ProdutoDTO> produtoDTOS = ProdutoDTO.fromEntity(produtos);
        List<ProdutoDTO> produtoDTOS = ProdutoDTO.fromEntity(produtos.getContent());
        /**Page<ProdutoDTO> produtoDTOPage = new PageImpl<>(produtoDTOS, produtos.getPageable(), produtos.getTotalElements());**/
        //return ResponseEntity.ok(produtos);
        //return ResponseEntity.ok(produtoDTOS);
        return ResponseEntity.ok(produtoDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity findAll(@PathVariable("id") long id){
        Produto produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
        try {
            Produto alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }

}
