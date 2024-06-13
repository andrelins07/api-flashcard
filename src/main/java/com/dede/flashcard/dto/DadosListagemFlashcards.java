package com.dede.flashcard.dto;

import com.dede.flashcard.model.Flashcard;

import java.time.LocalDate;

public record DadosListagemFlashcards(Integer id, String pergunta, String resposta, LocalDate dataCriacao, Integer nivel) {
    public DadosListagemFlashcards(Flashcard flashcard) {
        this(flashcard.getId(), flashcard.getPergunta(), flashcard.getResposta(), flashcard.getDataCriacao(), flashcard.getNivel());
    }
}