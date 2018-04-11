package calculation.results;

import io.Printable;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class InvalidArgumentsTest {

    @Test
    public void itPrintsAResultMessage() {
        String expectedMessageLine1 =
                "Arguments should be of the form:";
        String expectedMessageLine2 =
                "  <lottery-name> <winning-numbers> <ticket-numbers>";

        Printable unit = new InvalidArguments();

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessageLine1);
        verify(printStream, times(1)).println(expectedMessageLine2);
    }
}