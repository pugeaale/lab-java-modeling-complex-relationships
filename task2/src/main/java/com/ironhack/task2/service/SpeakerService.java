package com.ironhack.task2.service;

import com.ironhack.task2.model.Speaker;
import com.ironhack.task2.repository.SpeakerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    @Transactional
    public Speaker save(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        speakerRepository.deleteById(id);
    }
}
