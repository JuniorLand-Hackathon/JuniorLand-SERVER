package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Duration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class DurationResponse {
    private final int hours;
    private final int minutes;
    private final int seconds;

    public static DurationResponse from(final Duration duration) {
        return new DurationResponse(duration.getHours(), duration.getMinutes(), duration.getSeconds());
    }
}
