package com.example.demo.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordEncoderTest {

    @Test
    void encode() {
        // given
        String password = "user*1234";

        // when
        String encode = PasswordEncoder.encode(password);

        // then
        assertThat(encode).isNotEqualTo(password);
        assertThat(encode).startsWith("$2");
    }

    @Test
    void matches() {
        // given
        String password = "user*1234";
        String encode = PasswordEncoder.encode(password);

        // when
        boolean matches = PasswordEncoder.matches(password, encode);

        // then
        assertThat(matches).isTrue();
    }
}