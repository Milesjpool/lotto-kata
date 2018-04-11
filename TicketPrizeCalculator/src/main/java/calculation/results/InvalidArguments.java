package calculation.results;

import io.Printable;

import java.io.PrintStream;

public class InvalidArguments implements Printable {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("Arguments should be of the form:");
        printStream.println("  <lottery-name> <winning-numbers> <ticket-numbers>");
    }
}
