package com.sda.solid.dependency_inversion.after.highlevel;

public class Document {

    private IHeader header;
    private IContent content;

    public Document(IHeader header, IContent content) {
        this.header = header;
        this.content = content;
    }

    public void display() {
        header.build();
        content.build();
    }
}
