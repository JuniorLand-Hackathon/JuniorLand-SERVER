package com.hackerton.junior.service;

import com.hackerton.junior.domain.Education;
import com.hackerton.junior.domain.Gift;
import com.hackerton.junior.domain.Parent;
import com.hackerton.junior.dto.GiftRequest;
import com.hackerton.junior.dto.GiftsAndEducationsRequest;
import com.hackerton.junior.repository.EducationRepository;
import com.hackerton.junior.repository.GiftRepository;
import com.hackerton.junior.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JuniorService {
    private final EducationInfoProvider infoProvider;
    private final ParentRepository parentRepository;
    private final GiftRepository giftRepository;
    private final EducationRepository educationRepository;

    @Transactional
    public Parent findById(final String id) {
        final Optional<Parent> parent = parentRepository.findById(id);

        return parent.orElseGet(() -> parentRepository.save(new Parent(id)));
    }

    @Transactional
    public void save(final String parentId, final GiftsAndEducationsRequest request) {
        final Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부모입니다."));

        parent.setGifts(parseToGifts(request.getGifts()));
        parent.setEducations(parse(request.getVideoIds()));
        parentRepository.save(parent);
    }

    private List<Gift> parseToGifts(final List<GiftRequest> giftRequests) {
        final List<Gift> gifts = giftRequests.stream()
                .map(GiftRequest::toGift)
                .toList();

        return giftRepository.saveAll(gifts);
    }

    private List<Education> parse(final List<String> videoIds) {
        final List<Education> educations = infoProvider.getInfos(videoIds);

        return educationRepository.saveAll(educations);
    }
}
