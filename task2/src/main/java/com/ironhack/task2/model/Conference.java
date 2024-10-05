package com.ironhack.task2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Conference extends Event {

    @OneToMany(mappedBy = "conference")
    private List<Speaker> speakers = new ArrayList<>();

    public Conference(String title, String location, LocalDate date, Integer duration) {
        super(title, location, date, duration);
    }
}
