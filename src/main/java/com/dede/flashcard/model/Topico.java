package com.dede.flashcard.model;

import com.dede.flashcard.dto.DadosNome;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="Topico")
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @ManyToOne()
    private Cartao cartao;
    private Integer totalFlashcards;
    private LocalDate dataCriacao;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Flashcard> flashcards = new ArrayList<>();
    private Double nivelDificuldade;
    public Topico() {
    }
    public Topico(DadosNome dados, Cartao cartao) {
        this.titulo = dados.nome();
        this.cartao = cartao;
        this.totalFlashcards = 0;
        this.dataCriacao = LocalDate.now();
        this.nivelDificuldade = 0.0;
    }
    public void calcularNivelDificuldade(){
        if(!flashcards.isEmpty()){
            nivelDificuldade = flashcards.stream()
                    .collect(Collectors.averagingDouble(Flashcard::getNivel));
        }
    }
    public void adicionarFlashcards(Flashcard f){
        this.flashcards.add(f);
        this.totalFlashcards++;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Double getNivelDificuldade() {
        return nivelDificuldade;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getTotalFlashcards() {
        return totalFlashcards;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }
    public void removerFlashcards(Flashcard f) {
        this.flashcards.remove(f);
        this.totalFlashcards--;
    }
    public void atualizar(DadosNome dados) {

        if(dados.nome() != null) this.titulo = dados.nome();
    }
}
