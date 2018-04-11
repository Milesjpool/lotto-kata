package calculation;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CalculationResultTest {

    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    public void itPrintsResultMessage() {
        String resultMessage = "Some result message";

        CalculationResult unit = new CalculationResult(resultMessage);

        unit.print(printStream);

        verify(printStream, times(1)).println(resultMessage);
    }
}

