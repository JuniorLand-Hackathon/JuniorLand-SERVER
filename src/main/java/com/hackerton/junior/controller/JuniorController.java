package com.hackerton.junior.controller;

import com.hackerton.junior.domain.Parent;
import com.hackerton.junior.dto.GiftsAndEducationsRequest;
import com.hackerton.junior.dto.GiftsAndEducationsResponse;
import com.hackerton.junior.service.JuniorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/childrens")
public final class JuniorController {

    private final JuniorService juniorService;

    @GetMapping("/{id}")
    public ResponseEntity<GiftsAndEducationsResponse> getParentSettings(@PathVariable final String id) {
        final Parent parent = juniorService.findById(id);
        final GiftsAndEducationsResponse result = GiftsAndEducationsResponse.from(parent);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable final String id,
                                     @RequestBody final GiftsAndEducationsRequest request) {
        juniorService.save(id, request);

        return ResponseEntity.noContent().build();
    }
}
