package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Gift;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class GiftResponse {
    private final Long tagId;
    private final String url;

    public static GiftResponse from(final Gift gift) {
        return new GiftResponse(gift.getTagId(), gift.getUrl());
    }
}
