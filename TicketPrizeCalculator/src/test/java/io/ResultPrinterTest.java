package io;

import calculation.results.CalculationResult;
import io.ResultPrinter;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class ResultPrinterTest {

    private final PrintStream printStream = mock(PrintStream.class);
    private final CalculationResult result = mock(CalculationResult.class);

    @Test
    public void itPrintsResultMessage() {
        String resultMessage = "Some result message";
        when(result.getMessage()).thenReturn(resultMessage);

        ResultPrinter unit = new ResultPrinter(result);

        unit.print(printStream);

        verify(printStream, times(1)).println(resultMessage);
    }
}

