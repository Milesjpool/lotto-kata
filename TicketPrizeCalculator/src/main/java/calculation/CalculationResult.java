package calculation;

import io.Printable;

import java.io.PrintStream;

public abstract class CalculationResult implements Printable {
    private final String result;

    public CalculationResult(String result) {
        this.result = result;
    }

    @Override
    public void print(PrintStream printStream) {
        printStream.println(result);
    }
}
