package com.hackerton.junior.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public final class GiftsAndEducationsRequest {
    private List<GiftRequest> gifts;
    private List<String> videoIds;
}
