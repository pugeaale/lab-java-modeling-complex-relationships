package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.Event;
import com.ironhack.task2.model.Guest;
import com.ironhack.task2.model.GuestStatus;
import com.ironhack.task2.model.Speaker;
import com.ironhack.task2.service.EventService;
import com.ironhack.task2.service.GuestService;
import com.ironhack.task2.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final SpeakerService speakerService;
    private final GuestService guestService;
    private final EventService eventService;

    @Override
    public void run(String... args) throws Exception {
        Speaker speaker = new Speaker();
        speaker.setName("john");
        speaker.setPresentationDuration(33);
        speakerService.save(speaker);

        Guest guest = new Guest();
        guest.setName("julie");
        guest.setStatus(GuestStatus.ATTENDING);
        guestService.save(guest);

        Event event = new Event();
        event.setDuration(32);
        event.setLocation("paris");
        event.setTitle("mondial tattoo");
        event.setDate(LocalDate.now());
        eventService.save(event);
    }
}
