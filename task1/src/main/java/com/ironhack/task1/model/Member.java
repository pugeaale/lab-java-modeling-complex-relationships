package com.ironhack.task1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private ZonedDateTime renewalDate;
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "chapterId" , referencedColumnName = "id")
    private Chapter chapter;

    public Member(String name, ZonedDateTime renewalDate, MemberStatus status) {
        this.name = name;
        this.renewalDate = renewalDate;
        this.status = status;
    }
}
