package com.hackerton.junior.repository;

import com.hackerton.junior.domain.Duration;
import com.hackerton.junior.domain.Education;
import com.hackerton.junior.domain.Gift;
import com.hackerton.junior.domain.Parent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DataJpaTest
class ParentRepositoryTest {

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private GiftRepository giftRepository;
    @Autowired
    private EducationRepository educationRepository;

    @DisplayName("부모를 저장할 수 있다")
    @Test
    void save() {
        //given
        final Parent parent = new Parent("이름1234");

        //when
        final Parent persisted = parentRepository.save(parent);

        //then
        assertThat(persisted.getId()).isEqualTo("이름1234");
    }

    @DisplayName("부모의 선물 리스트에 선물을 추가할 수 있다")
    @Test
    void addGift() {
        //given
        final Parent parent = parentRepository.save(new Parent("이름1234"));
        final Gift gift = giftRepository.save(new Gift("주소입니당"));

        //when
        parent.addGift(gift);
        final List<Gift> persistedGifts = parentRepository.findById("이름1234").get().getGifts();

        //then
        assertSoftly(soft -> {
            assertThat(persistedGifts).hasSize(1);
            assertThat(persistedGifts.get(0).getUrl()).isEqualTo("주소입니당");
            assertThat(giftRepository.findAll()).hasSize(1);
        });
    }

    @DisplayName("부모의 선물 리스트에 선물을 추가할 수 있다")
    @Test
    void addEducation() {
        //given
        final Parent parent = parentRepository.save(new Parent("이름1234"));
        final Education education = educationRepository.save(new Education("주소", new Duration()));

        //when
        parent.addEducation(education);
        final List<Education> persistedEducations = parentRepository.findById("이름1234").get().getEducations();

        //then
        assertSoftly(soft -> {
            assertThat(persistedEducations).hasSize(1);
            assertThat(persistedEducations.get(0).getVideoId()).isEqualTo("주소");
            assertThat(educationRepository.findAll()).hasSize(1);
        });
    }
}
