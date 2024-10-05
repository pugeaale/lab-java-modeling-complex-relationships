package com.ironhack.task2.service;

import com.ironhack.task2.model.Guest;
import com.ironhack.task2.repository.GuestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    @Transactional
    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }
}
