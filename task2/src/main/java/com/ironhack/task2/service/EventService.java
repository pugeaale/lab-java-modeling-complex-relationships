package com.ironhack.task2.service;

import com.ironhack.task2.model.Event;
import com.ironhack.task2.repository.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    @Transactional
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public long count() {
        return eventRepository.count();
    }
}
