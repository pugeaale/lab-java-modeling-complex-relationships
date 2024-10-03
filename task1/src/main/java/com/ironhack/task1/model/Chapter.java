package com.ironhack.task1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String district;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "presidentId")
    private Member president;

    public Chapter(String district, String name) {
        this.district = district;
        this.name = name;
    }
}
