package calculation;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CalculationResultTest {

    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    public void itPrintsDefinedResultMessage() {
        String resultMessage = "Some result message";

        CalculationResult unit = new TestCalculationResult(resultMessage);

        unit.print(printStream);

        verify(printStream, times(1)).println(resultMessage);
    }

    private class TestCalculationResult extends CalculationResult {
        TestCalculationResult(String resultMessage) {
            super(resultMessage);
        }
    }
}

