package com.ironhack.task2.service;

import com.ironhack.task2.model.Exposition;
import com.ironhack.task2.repository.ExpositionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpositionService {
    private final ExpositionRepository expositionRepository;

    @Transactional
    public Exposition save(Exposition exposition) {
        return expositionRepository.save(exposition);
    }

    public long count() {
        return expositionRepository.count();
    }
}
