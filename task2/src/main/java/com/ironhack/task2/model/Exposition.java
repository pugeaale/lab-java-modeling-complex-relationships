package com.ironhack.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Exposition extends Event {

    public Exposition(String title, String location, LocalDate date, Integer duration) {
        super(title, location, date, duration);
    }
}
