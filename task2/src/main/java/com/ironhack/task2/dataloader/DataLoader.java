package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.*;
import com.ironhack.task2.service.*;
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
    private final ExpositionService expositionService;
    private final ConferenceService conferenceService;

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

        Exposition exposition = new Exposition();
        exposition.setDuration(4);
        exposition.setLocation("PANAME");
        exposition.setTitle("mondial_tattoo");
        exposition.setDate(LocalDate.now());
        expositionService.save(exposition);

        Conference conference = new Conference();
        conference.setDuration(3);
        conference.setLocation("PANAME");
        conference.setTitle("devoxx 2025");
        conference.setDate(LocalDate.now());
        conferenceService.save(conference);
    }
}
