package calculation.results;

import io.Printable;

import java.io.PrintStream;

public class UnsuccessfulResult implements Printable {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket did not win a prize.");
    }
}
