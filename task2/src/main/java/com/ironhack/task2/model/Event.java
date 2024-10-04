package com.ironhack.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
date: the date the event will take place
duration: the duration of the event
location: the location of the event
title: the title of the event
 */
@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String location;
    private LocalDate date;
    private Integer duration;

    public Event(String title, String location, LocalDate date, Integer duration) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.duration = duration;
    }
}
