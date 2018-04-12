package calculation.lotteries.results;

import io.Printable;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UnrecognisedTicketTest {


    @Test
    public void itPrintsAResultMessage() {
        String expectedMessage = "This is not a recognised ticket.";

        Printable unit = new UnrecognisedTicket();

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }
}
