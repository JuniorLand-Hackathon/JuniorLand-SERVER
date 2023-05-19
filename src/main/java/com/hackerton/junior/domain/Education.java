package com.hackerton.junior.domain;

import com.google.api.services.youtube.model.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Education {
    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String videoId;
    @Embedded
    private Duration duration;

    public Education(final String videoId, final Duration duration) {
        this.videoId = videoId;
        this.duration = duration;
    }

    public static Education from(final Video video) {
        final String id = video.getId();
        final String duration = video.getContentDetails().getDuration();

        return new Education(id, Duration.from(duration));
    }
}
