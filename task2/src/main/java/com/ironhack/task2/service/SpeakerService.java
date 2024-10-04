package com.ironhack.task2.service;

import com.ironhack.task2.model.Speaker;
import com.ironhack.task2.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    public Speaker save(Speaker speaker) {
        return speakerRepository.save(speaker);
    }
}
