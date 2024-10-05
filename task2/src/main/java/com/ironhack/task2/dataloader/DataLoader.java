package com.ironhack.task2.dataloader;

import com.ironhack.task2.model.*;
import com.ironhack.task2.service.*;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

        testCreateExposition();
        testCreateExpositionWithGuest();
        testDeleteGuestFromExposition();
        testCreateConference();
        testCreateConferenceWithSpeaker();
        testDeletingSpeakerFromConference();
        testCreatingConferenceWithGuest();
        testDeletingGuestFromConference();
    }

    public void testCreateExposition() {
        Exposition expositionSaved = createNewExposition();
        Optional<Exposition> result = expositionService.findById(expositionSaved.getId().longValue());
        if(result.isPresent()) {
            System.out.println(result.get().getId() == expositionSaved.getId());
        }
    }

    public void testCreateExpositionWithGuest() {
        Guest guest = createNewGuest(createNewExposition());
        Optional<Guest> result = guestService.findById(guest.getId().longValue());
        if(result.isPresent()) {
            System.out.println(result.get().getId() == guest.getId());
        }
    }

    public void testDeleteGuestFromExposition() {
        Guest guest = createNewGuest(createNewExposition());
        guestService.deleteById(guest.getId());
        Optional<Guest> result = guestService.findById(guest.getId().longValue());
        if(result.isEmpty()) {
            System.out.println("TEST deleting exposition guest : OK");
        }
    }

    public void testCreateConference() {
        Conference confSaved = createNewConference();
        Optional<Conference> conferenceRetrieved = conferenceService.findById(confSaved.getId().longValue());
        if(conferenceRetrieved.isPresent()) {
            System.out.println(conferenceRetrieved.get().getId() == confSaved.getId());
        }
    }

    public void testCreateConferenceWithSpeaker() {
        Speaker speaker = createNewSpeaker(createNewConference());
        Optional<Speaker> result = speakerService.findById(speaker.getId().longValue());
        if(result.isPresent()) {
            System.out.println(result.get().getId() == speaker.getId());
        }
    }

    public void testDeletingSpeakerFromConference() {
        Speaker speaker = createNewSpeaker(createNewConference());
        speakerService.deleteById(speaker.getId());
        Optional<Speaker> result = speakerService.findById(speaker.getId().longValue());
        if(result.isEmpty()) {
            System.out.println("TEST deleting speaker : OK");
        }
    }

    public void testCreatingConferenceWithGuest() {
        Guest guest = createNewGuest(createNewConference());
        Optional<Guest> result = guestService.findById(guest.getId().longValue());
        if(result.isPresent()) {
            System.out.println(result.get().getId() == guest.getId());
        }
    }

    public void testDeletingGuestFromConference() {
        Guest guest = createNewGuest(createNewConference());
        guestService.deleteById(guest.getId());
        Optional<Guest> result = guestService.findById(guest.getId().longValue());
        if(result.isEmpty()) {
            System.out.println("TEST deleting conference guest : OK");
        }
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
