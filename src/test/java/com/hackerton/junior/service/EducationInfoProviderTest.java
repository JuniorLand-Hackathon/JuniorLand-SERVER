package com.hackerton.junior.service;

import com.hackerton.junior.domain.Education;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EducationInfoProviderTest {
    @Autowired
    private EducationInfoProvider educationInfoProvider;

    @DisplayName("유튜브 영상 시간 가져오기")
    @Test
    void getDuration() {
        //given
        final String url = "zIMUVTbRmek";

        //when
        final List<Education> educations = educationInfoProvider.getInfos(List.of(url));

        //then
        assertThat(educations).hasSize(1);
    }

}
