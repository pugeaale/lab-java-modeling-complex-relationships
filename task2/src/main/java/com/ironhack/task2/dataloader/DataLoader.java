package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.Guest;
import com.ironhack.task2.model.GuestStatus;
import com.ironhack.task2.model.Speaker;
import com.ironhack.task2.service.GuestService;
import com.ironhack.task2.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final SpeakerService speakerService;
    private final GuestService guestService;

    @Override
    public void run(String... args) throws Exception {
        Speaker speaker = new Speaker();
        speaker.setName("warren");
        speaker.setPresentationDuration(33);
        speakerService.save(speaker);

        Guest guest = new Guest();
        guest.setName("azer");
        guest.setStatus(GuestStatus.ATTENDING);
        guestService.save(guest);
    }
}
