package io;

import calculation.results.CalculationResult;

import java.io.PrintStream;

public class ResultPrinter implements Printable {
    private final CalculationResult result;

    public ResultPrinter(CalculationResult result) {
        this.result = result;
    }

    @Override
    public void print(PrintStream printStream) {
        printStream.println(result.getMessage());
    }

}
