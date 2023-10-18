package com.roadhub.demonio.repository;

import com.roadhub.demonio.model.Cliente;
import com.roadhub.demonio.model.Fornecedor;
import com.roadhub.demonio.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, CustomQuerydslPredicateExecutor<Fornecedor> {

}
