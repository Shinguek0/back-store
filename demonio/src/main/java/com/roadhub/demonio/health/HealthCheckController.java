package com.roadhub.demonio.health;

import com.roadhub.demonio.model.*;
import com.roadhub.demonio.repository.ClienteRepository;
import com.roadhub.demonio.repository.ProdutoRepository;
import com.roadhub.demonio.repository.ServicoRepository;
import com.roadhub.demonio.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HealthCheckController {
    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;


    @GetMapping("/health")
    public String healthCheck(){
        return "Ok";
    }

    @GetMapping("/suamae")
    public String suaMae(String nomeMae){
        return "Sua mãe "+nomeMae+" é minha!";
    }

    @GetMapping("/teste")
    public String test(){
        Produto produto = new Produto();
        produto.setDescricao("PC GAMER GAMER cOM LED");
        produto.setNome("Pc Intel platinum");
        produto.setValorUnitario(1000.00);

        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.DISPONIVEL);
        produto.setEstocavel(Boolean.TRUE);

        produto = produtoRepository.save(produto);

        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.20);
        servico.setDescricao("Boquete gratis");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(6969.00);

        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("696969");
        cliente.setRg("2");
        cliente.setNome("Bruno");
        cliente.setEmail("Xaolin_matador_de_porco@hotmail.com");
        cliente.setEnderecao("Rua tudos bando tu dos bago");
        cliente.setTelefone("231");

        cliente = clienteRepository.save(cliente);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("Venda 0bino");
        venda.setFormaPagamento(FormaPagamento.PIX);

        ItemVenda itemVenda = new ItemVenda(produto, 100.00, 1.0, 10.00);
        ItemVenda itemVenda1 = new ItemVenda(servico, 120.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemVenda1);

        venda = vendaRepository.save(venda);

        return "Finalizado PRODUTO: "+produto+" - "+produto.getId();
    }
}
