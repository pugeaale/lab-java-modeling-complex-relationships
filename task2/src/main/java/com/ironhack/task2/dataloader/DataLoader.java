package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.*;
import com.ironhack.task2.service.*;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
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
    private Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        Event event = new Event();
        event.setDuration(32);
        event.setLocation("paris");
        event.setTitle("mondial tattoo");
        event.setDate(LocalDate.now());
        eventService.save(event);

        Exposition expositionSaved = createNewExposition();

        Guest guestSaved = createNewGuest(expositionSaved);

        Conference confSaved = createNewConference();

        Speaker speakerSaved = createNewSpeaker(confSaved);
    }

    private Guest createNewGuest( Event event) {
        Guest guest = new Guest();
        guest.setName(faker.name().femaleFirstName());
        guest.setStatus(GuestStatus.ATTENDING);
        guest.setEvent(event);
        return guestService.save(guest);
    }

    private Exposition createNewExposition() {
        Exposition exposition = new Exposition();
        exposition.setDuration(faker.number().positive());
        exposition.setLocation(faker.address().city());
        exposition.setTitle(faker.artist().name());
        exposition.setDate(LocalDate.now());
        return expositionService.save(exposition);
    }

    private Speaker createNewSpeaker(Conference confSaved) {
        Speaker speaker = new Speaker();
        speaker.setName(faker.name().fullName());
        speaker.setPresentationDuration(faker.number().positive());
        speaker.setConference(confSaved);
        return speakerService.save(speaker);
    }

    private Conference createNewConference() {
        Conference conference = new Conference();
        conference.setDuration(faker.number().positive());
        conference.setLocation(faker.address().city());
        conference.setTitle(faker.community().character());
        conference.setDate(LocalDate.now());
        return conferenceService.save(conference);
    }


}
