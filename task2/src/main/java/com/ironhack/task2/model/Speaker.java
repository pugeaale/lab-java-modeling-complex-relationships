package com.ironhack.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer presentationDuration;

    public Speaker(String name, Integer presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }
}
