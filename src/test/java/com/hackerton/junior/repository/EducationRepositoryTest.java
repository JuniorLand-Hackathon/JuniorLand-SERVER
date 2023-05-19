package com.hackerton.junior.repository;

import com.hackerton.junior.domain.Duration;
import com.hackerton.junior.domain.Education;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DataJpaTest
class EducationRepositoryTest {

    @Autowired
    private EducationRepository educationRepository;

    @DisplayName("교육 영상 저장")
    @Test
    void save() {
        //given
        final Education education = new Education("주소", new Duration());

        //when
        final Education persisted = educationRepository.save(education);

        //then
        assertSoftly(soft -> {
            assertThat(persisted.getId()).isNotNull();
            assertThat(persisted.getVideoId()).isEqualTo(education.getVideoId());
        });
    }
}
