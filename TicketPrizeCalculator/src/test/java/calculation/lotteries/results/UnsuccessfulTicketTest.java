package calculation.lotteries.results;

import io.Printable;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UnsuccessfulTicketTest {

    @Test
    public void itPrintsAResultMessage() {
        String expectedMessage = "This ticket did not win a prize.";

        Printable unit = new UnsuccessfulTicket();

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }
}