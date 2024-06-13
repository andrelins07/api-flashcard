package com.dede.flashcard.repository;

import com.dede.flashcard.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Integer> {
}
