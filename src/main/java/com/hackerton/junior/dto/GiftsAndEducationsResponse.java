package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Parent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public final class GiftsAndEducationsResponse {
    private final int giftsSize;
    private final int educationsSize;
    private final List<GiftResponse> gifts;
    private final List<EducationResponse> educations;

    public static GiftsAndEducationsResponse from(final Parent parent) {
        final List<EducationResponse> educations = parseEducations(parent);
        final List<GiftResponse> gifts = parseGifts(parent);

        return new GiftsAndEducationsResponse(gifts.size(), educations.size(), gifts, educations);
    }

    private static List<EducationResponse> parseEducations(final Parent parent) {
        return parent.getEducations().stream()
                .map(EducationResponse::from)
                .toList();
    }

    private static List<GiftResponse> parseGifts(final Parent parent) {
        return parent.getGifts().stream()
                .map(GiftResponse::from)
                .toList();
    }
}
