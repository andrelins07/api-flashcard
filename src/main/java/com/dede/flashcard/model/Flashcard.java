package com.dede.flashcard.model;

import com.dede.flashcard.dto.DadosFlashcard;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity(name="FlashCard")
@Table(name="flashcard")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Topico topico;
    private String pergunta;
    private String resposta;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    public Flashcard() {
    }
    public Flashcard(DadosFlashcard dados, Topico topico) {
        this.pergunta = dados.pergunta();
        this.resposta = dados.resposta();
        this.dataCriacao = LocalDate.now();
        this.nivel = Nivel.fromInteger(dados.nivel());
        this.topico = topico;
    }

    public Integer getId() {
        return id;
    }

    public Topico getTopico() {
        return topico;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Integer getNivel() {
        return nivel.getValor();
    }

    public void atualizar(DadosFlashcard dados) {
        this.pergunta = dados.pergunta();
        this.resposta = dados.resposta();
        this.nivel = Nivel.fromInteger(dados.nivel());
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", topico=" + topico +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", nivel=" + nivel +
                '}';
    }
}
