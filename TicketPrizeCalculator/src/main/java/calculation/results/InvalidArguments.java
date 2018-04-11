package calculation.results;

import java.io.PrintStream;

public class InvalidArguments implements CalculationResult {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("Arguments should be of the form:");
        printStream.println("  <lottery-name> <winning-numbers> <ticket-numbers>");
    }
}
