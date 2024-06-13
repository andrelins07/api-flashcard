package com.dede.flashcard.dto;

import com.dede.flashcard.model.Topico;
import java.time.LocalDate;

public record DadosListagemTopico(Integer id, String titulo, Integer totalFlashCards,LocalDate dataCriacao, Double nivel) {
    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getTotalFlashcards(), topico.getDataCriacao(), topico.getNivelDificuldade());
    }
}
