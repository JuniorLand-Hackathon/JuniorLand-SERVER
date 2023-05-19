package com.hackerton.junior.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Gift {
    @Id
    @Column(name = "gift_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;

    public Gift(final String url) {
        this.url = url;
    }
}
