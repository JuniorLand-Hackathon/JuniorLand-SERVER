package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Parent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public final class GiftsAndEducationsResponse {
    private final List<GiftResponse> gifts;
    private final List<EducationResponse> educations;

    public static GiftsAndEducationsResponse from(final Parent parent) {
        final List<EducationResponse> educations = parent.getEducations().stream()
                .map(EducationResponse::from)
                .toList();

        final List<GiftResponse> gifts = parent.getGifts().stream()
                .map(GiftResponse::from)
                .toList();

        return new GiftsAndEducationsResponse(gifts, educations);
    }
}
