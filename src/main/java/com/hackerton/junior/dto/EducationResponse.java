package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Education;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class EducationResponse {
    private final String videoId;
    private final DurationResponse duration;

    public static EducationResponse from(final Education education) {
        final DurationResponse duration = DurationResponse.from(education.getDuration());
        return new EducationResponse(education.getVideoId(), duration);
    }
}
