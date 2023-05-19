package com.hackerton.junior.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Parent {
    @Id
    @Column(name = "parent_id")
    private String id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private List<Gift> gifts = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private List<Education> educations = new ArrayList<>();

    public Parent(final String id) {
        this.id = id;
    }

    public void addGift(final Gift gift) {
        gifts.add(gift);
    }

    public void addEducation(final Education education) {
        educations.add(education);
    }
}
