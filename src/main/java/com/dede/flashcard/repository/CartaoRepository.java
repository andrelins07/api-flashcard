package com.dede.flashcard.repository;

import com.dede.flashcard.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
}
