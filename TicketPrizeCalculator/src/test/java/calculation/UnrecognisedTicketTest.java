package calculation;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UnrecognisedTicketTest {

    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    public void itPrintsAResultMessage() {
        String expectedMessage = "This is not a recognised ticket.";

        CalculationResult unit = new UnrecognisedTicket();

        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }
}
