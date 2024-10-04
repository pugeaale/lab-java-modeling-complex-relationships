package com.ironhack.task2.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Conference extends Event {

    public Conference(String title, String location, LocalDate date, Integer duration) {
        super(title, location, date, duration);
    }
}
