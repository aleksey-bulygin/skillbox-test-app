package com.skillbox.app.service;

import com.skillbox.app.models.TextContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TextDataService {
    private final static int TEXT_LENGTH = "test data".length();

    private final TextDataRepository repository;

    @Autowired
    public TextDataService(TextDataRepository repository) {
        this.repository = repository;
    }


    public boolean isCorrectText(final String input) {
        return !StringUtils.isEmpty(input) && input.length() < TEXT_LENGTH;
    }

    public void save(final TextContainer textContainer) {
        repository.save(textContainer);
    }
}
