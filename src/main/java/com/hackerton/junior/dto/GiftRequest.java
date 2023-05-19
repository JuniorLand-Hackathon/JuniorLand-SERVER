package com.hackerton.junior.dto;

import com.hackerton.junior.domain.Gift;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public final class GiftRequest {
    private Long tagId;
    private String url;

    public Gift toGift() {
        return new Gift(tagId, url);
    }
}
