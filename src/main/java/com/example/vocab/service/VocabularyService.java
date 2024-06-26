package com.example.vocab.service;

import com.example.vocab.entity.Vocabulary;
import com.example.vocab.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class VocabularyService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    public Vocabulary getRandomVocabulary() {
        List<Vocabulary> vocabularies = vocabularyRepository.findAll();
        if (vocabularies.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return vocabularies.get(random.nextInt(vocabularies.size()));
    }
}
