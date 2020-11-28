package com.skillbox.app.service;

import com.skillbox.app.models.TextContainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextDataRepository extends JpaRepository<TextContainer, Long> {
}
