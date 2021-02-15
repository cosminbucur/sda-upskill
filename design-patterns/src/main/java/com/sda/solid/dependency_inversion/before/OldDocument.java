package com.sda.solid.dependency_inversion.before;

public class OldDocument {

    private OldHeader oldHeader = new OldHeader();
    private OldContent oldContent = new OldContent();

    public void display() {
        oldHeader.build();
        oldContent.build();
    }
}
