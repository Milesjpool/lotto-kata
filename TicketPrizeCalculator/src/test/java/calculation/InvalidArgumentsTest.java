package calculation;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InvalidArgumentsTest {

    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    public void itPrintsAResultMessage() {
        String expectedMessage =
                "Arguments should be of the form: <lottery-name> <winning-numbers> <ticket-numbers>";

        CalculationResult unit = new InvalidArguments();

        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }
}