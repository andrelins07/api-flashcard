package com.dede.flashcard.dto;

import com.dede.flashcard.model.Topico;

import java.util.List;


public record DadosDetalhamentoTopico(Integer id, String titulo, String nomeCartao, Integer totalFlashcards, List<DadosListagemFlashcards> flashcards) {
    public DadosDetalhamentoTopico(Topico topico) {
            this(topico.getId(), topico.getTitulo(), topico.getCartao().getNome(),topico.getTotalFlashcards(),topico.getFlashcards().stream().map(DadosListagemFlashcards::new).toList());
    }
}

