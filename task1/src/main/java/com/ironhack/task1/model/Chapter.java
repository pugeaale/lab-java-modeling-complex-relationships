package com.ironhack.task1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "chapter", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "chapterId", referencedColumnName = "id")
    private List<Member> members = new ArrayList<Member>();

    public Chapter(String district, String name) {
        this.district = district;
        this.name = name;
    }

    public void addMember(Member member) {
        member.setChapter(this);
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }
}
