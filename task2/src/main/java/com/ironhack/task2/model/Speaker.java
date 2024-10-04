package com.ironhack.task2.model;

import jakarta.persistence.*;
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

    //we want a lazy loading by default eager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conferenceId" , referencedColumnName = "id")
    private Conference conference;

    public Speaker(String name, Integer presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }
}
