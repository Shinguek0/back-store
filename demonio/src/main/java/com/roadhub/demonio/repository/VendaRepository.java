package com.roadhub.demonio.repository;

import com.roadhub.demonio.model.Cliente;
import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>, CustomQuerydslPredicateExecutor<Venda> {

}
