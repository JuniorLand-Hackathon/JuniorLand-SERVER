package com.hackerton.junior.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DurationTest {

    @ValueSource(strings = {"PTM1S", "P12T59MS", "P1TM23S", "P1T1M1S"})
    @ParameterizedTest(name = "{0}을 시, 분, 초로 파싱할 수 있다")
    void parse(String duration) {
        assertDoesNotThrow(() -> Duration.from(duration));
    }

}
