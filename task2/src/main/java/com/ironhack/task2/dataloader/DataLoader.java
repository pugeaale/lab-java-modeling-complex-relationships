package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.Speaker;
import com.ironhack.task2.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final SpeakerService speakerService;

    @Override
    public void run(String... args) throws Exception {
        Speaker speaker = new Speaker();
        speaker.setName("ddd");
        speaker.setPresentationDuration(33);
        speakerService.save(speaker);
    }
}
