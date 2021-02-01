package com.sda.patterns.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdapterTest {

    @Test
    void givenText_whenFormatText_shouldFormatWithNewLine() {
        String text = "Employee 1. Employee 2. Employee 3.";
        TextFormattable newLineFormatter = new NewLineFormatter();

        String actual = newLineFormatter.formatText(text);

        assertThat(actual).isEqualTo("Employee 1\n Employee 2\n Employee 3\n");
    }

    @Test
    void givenText_whenFormatText_shouldFormatWithCsv() {
        String text = "Employee 1. Employee 2. Employee 3.";
        CsvFormatter csvFormatter = new CsvFormatter();
        TextFormattable csvAdapter = new CsvAdapterImpl(csvFormatter);

        String actual = csvAdapter.formatText(text);

        assertThat(actual).isEqualTo("Employee 1, Employee 2, Employee 3,");
    }
}