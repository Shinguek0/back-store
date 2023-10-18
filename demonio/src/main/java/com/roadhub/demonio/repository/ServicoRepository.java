package com.roadhub.demonio.repository;

import com.roadhub.demonio.model.Cliente;
import com.roadhub.demonio.model.Produto;
import com.roadhub.demonio.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>, CustomQuerydslPredicateExecutor<Servico> {

}
