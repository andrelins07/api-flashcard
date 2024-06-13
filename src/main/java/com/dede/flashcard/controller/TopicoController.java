package com.dede.flashcard.controller;

import com.dede.flashcard.dto.*;
import com.dede.flashcard.model.Flashcard;
import com.dede.flashcard.repository.CartaoRepository;
import com.dede.flashcard.repository.FlashcardRepository;
import com.dede.flashcard.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    FlashcardRepository flashcardRepository;

    @CrossOrigin
    @GetMapping("/{id}")
    public DadosDetalhamentoTopico detalharTopico(@PathVariable Integer id){
        var dados = topicoRepository.getReferenceById(id);
        return new DadosDetalhamentoTopico(dados);
    }
    @CrossOrigin
    @PutMapping("/{id}")
    @Transactional
    public DadosListagemTopico atualizarTopico(@PathVariable Integer id, @RequestBody DadosNome dados){
        var topico = topicoRepository.getReferenceById(id);
        topico.atualizar(dados);
        return new DadosListagemTopico(topico);
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    @Transactional
    public void excluirTopico(@PathVariable Integer id){
        var topico = topicoRepository.getReferenceById(id);
        topico.getCartao().removerTopico(topico);
        topicoRepository.deleteById(id);
    }
    @CrossOrigin
    @Transactional
    @PostMapping("/{id}")
    public DadosListagemFlashcards adicionarFlashcard(@PathVariable Integer id, @RequestBody DadosFlashcard dados){

        var topico = topicoRepository.getReferenceById(id);
        var novo = new Flashcard(dados, topico);
        topico.adicionarFlashcards(novo);
        flashcardRepository.save(novo);

        return new DadosListagemFlashcards(novo);
    }
    @CrossOrigin
    @Transactional
    @PutMapping("/flashcard/{id}")
    public DadosListagemFlashcards alterarFlashcard(@PathVariable Integer id, @RequestBody DadosFlashcard dados){

        var flashcard = flashcardRepository.getReferenceById(id);
        flashcard.atualizar(dados);

        return new DadosListagemFlashcards(flashcard);
    }
    @CrossOrigin
    @Transactional
    @DeleteMapping("/flashcard/{id}")
    public void excluirFlashcard(@PathVariable Integer id){
        var flashcard = flashcardRepository.getReferenceById(id);

        flashcard.getTopico().removerFlashcards(flashcard);
        flashcardRepository.deleteById(id);

    }

 }

