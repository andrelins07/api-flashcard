package com.dede.flashcard.dto;

import com.dede.flashcard.model.Cartao;
import java.util.List;

public record DadosDetalhamentoCartao(Integer id, String nome, Integer totalTopicos, List<DadosListagemTopico> topicos) {
    public DadosDetalhamentoCartao(Cartao cartao) {
        this(cartao.getId(), cartao.getNome(), cartao.getTotalTopicos(),cartao.getTopicos().stream().map(DadosListagemTopico::new).toList());
    }
}