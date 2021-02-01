package com.sda.patterns.structural.adapter;

public class CsvAdapterImpl implements TextFormattable {

    private CsvFormattable csvFormatter;

    public CsvAdapterImpl(CsvFormattable csvFormatter) {
        this.csvFormatter = csvFormatter;
    }

    @Override
    public String formatText(String text) {
        return csvFormatter.formatCsvText(text);
    }

}
