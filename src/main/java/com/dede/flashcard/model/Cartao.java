package com.dede.flashcard.model;
import com.dede.flashcard.dto.DadosNome;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Cartao")
@Table(name="cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer totalTopicos;
    private LocalDate dataCriacao;
    @OneToMany(mappedBy = "cartao",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topico> topicos = new ArrayList<>();
    public Cartao(DadosNome dados) {
        this.nome = dados.nome();
        this.totalTopicos = 0;
        this.dataCriacao = LocalDate.now();
    }
    public Cartao() {
    }
    public void adicionarTopicos(Topico topico){
        topicos.add(topico);
        totalTopicos++;
    }
    public void removerTopico(Topico t) {
        this.topicos.remove(t);
        totalTopicos--;
    }
    public void atualizarNome(DadosNome dados) {
        if(!dados.nome().isBlank()){
            this.nome = dados.nome();
        }
    }
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTotalTopicos() {
        return totalTopicos;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", totalTopicos=" + totalTopicos +
                ", dataCriacao=" + dataCriacao +
                ", topicos=" + topicos +
                '}';
    }
}
