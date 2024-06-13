package com.dede.flashcard.controller;

import com.dede.flashcard.dto.DadosDetalhamentoCartao;
import com.dede.flashcard.dto.DadosListagemCartao;
import com.dede.flashcard.dto.DadosListagemTopico;
import com.dede.flashcard.dto.DadosNome;
import com.dede.flashcard.model.Cartao;
import com.dede.flashcard.model.Topico;
import com.dede.flashcard.repository.CartaoRepository;
import com.dede.flashcard.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    CartaoRepository repository;
    @Autowired
    TopicoRepository topicoRepository;

    @CrossOrigin
    @GetMapping()
    public List<DadosListagemCartao> listarTodosCartoe(){
        List<Cartao> cartaoList = repository.findAll();
        return cartaoList.stream().map(DadosListagemCartao::new).toList();
    }
    @CrossOrigin
    @PostMapping
    @Transactional
    public DadosListagemCartao adicionarNovoCartao(@RequestBody DadosNome dados){
        var cartao = new Cartao(dados);
        System.out.println(cartao);
        repository.save(cartao);
        return new DadosListagemCartao(cartao);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public DadosDetalhamentoCartao detalharCartao(@PathVariable Integer id){
        var dados = repository.getReferenceById(id);
        return new DadosDetalhamentoCartao(dados);
    }
    @CrossOrigin
    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @CrossOrigin
    @Transactional
    @PutMapping("/{id}")
    public DadosListagemCartao alterarNomeCartao(@PathVariable Integer id, @RequestBody DadosNome nome){
        var cartao = repository.getReferenceById(id);
        cartao.atualizarNome(nome);
        return new DadosListagemCartao(cartao);
    }
    @CrossOrigin
    @Transactional
    @PostMapping("/{id}")
    public DadosListagemTopico adicionarTopico(@PathVariable Integer id, @RequestBody DadosNome nome){
        var cartao = repository.getReferenceById(id);
        var topico = new Topico(nome, cartao);
        topicoRepository.save(topico);
        cartao.adicionarTopicos(topico);
        return new DadosListagemTopico(topico);
    }
}
