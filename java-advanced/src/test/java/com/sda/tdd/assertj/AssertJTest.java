package com.sda.tdd.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJTest() {
        String text = "abc";
        assertThat(text).isEqualTo("abc");

        String[] stringArray = {"abc", "cde", "efg"};
        assertThat(stringArray)
                .hasSize(3)
                .contains("cde")
                .doesNotContain("xyz");
    }
}
