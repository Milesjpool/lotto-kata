package calculation.results;

import io.Printable;

import java.io.PrintStream;

public class UnrecognisedTicket implements Printable {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("This is not a recognised ticket.");
    }
}
