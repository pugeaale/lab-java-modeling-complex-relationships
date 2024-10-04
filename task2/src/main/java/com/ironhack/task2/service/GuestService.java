package com.ironhack.task2.service;

import com.ironhack.task2.model.Guest;
import com.ironhack.task2.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }
}
