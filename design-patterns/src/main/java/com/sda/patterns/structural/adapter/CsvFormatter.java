package com.sda.patterns.structural.adapter;

public class CsvFormatter implements CsvFormattable {

    @Override
    public String formatCsvText(String text) {
        return text.replace(".", ",");
    }
}
