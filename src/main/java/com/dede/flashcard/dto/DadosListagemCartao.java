package com.dede.flashcard.dto;

import com.dede.flashcard.model.Cartao;
import com.dede.flashcard.model.Topico;
import java.time.LocalDate;
import java.util.List;

public record DadosListagemCartao(Integer id, String nome, Integer totalTopicos, LocalDate dataCriacao) {
    public DadosListagemCartao(Cartao cartao){
        this(cartao.getId(), cartao.getNome(), cartao.getTotalTopicos(), cartao.getDataCriacao());
    }

}
