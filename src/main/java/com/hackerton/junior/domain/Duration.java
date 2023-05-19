package com.hackerton.junior.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class Duration {
    private static final char HOUR = 'T';
    private static final char MINUTE = 'M';
    private static final char SECOND = 'S';

    private int hours;
    private int minutes;
    private int seconds;

    public static Duration from(final String duration) {
        final String hours = duration.substring(1, duration.indexOf(HOUR));
        final String minutes = duration.substring(duration.indexOf(HOUR) + 1, duration.indexOf(MINUTE));
        final String seconds = duration.substring(duration.indexOf(MINUTE) + 1, duration.indexOf(SECOND));

        return new Duration(parse(hours), parse(minutes), parse(seconds));
    }

    public static int parse(final String duration) {
        try {
            return Integer.parseInt(duration);
        } catch (NumberFormatException ignored) {
            return 0;
        }
    }
}
