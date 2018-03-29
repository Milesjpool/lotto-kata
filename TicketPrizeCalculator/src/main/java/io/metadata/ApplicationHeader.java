package io.metadata;

import io.Printable;

import java.io.PrintStream;

public class ApplicationHeader implements Printable {
    private static final String IMPLEMENTER = "Miles Pool";
    private static final String APPLICATION_NAME = "Calculating Lottery Winners";
    private static final String VERSION = "1.0.0";

    public void print(PrintStream printStream) {
        printStream.println(this);
    }

    @Override
    public String toString() {
        return IMPLEMENTER + " - " + APPLICATION_NAME + " v" + VERSION;
    }
}
