package com.ironhack.task2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
date: the date the event will take place
duration: the duration of the event
location: the location of the event
title: the title of the event
 */
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String location;
    private LocalDate date;
    private Integer duration;

    @OneToMany(mappedBy = "event")
    private List<Guest> guests = new ArrayList<>();

    public Event(String title, String location, LocalDate date, Integer duration) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.duration = duration;
    }
}
