package calculation.results;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class UnsuccessfulResultTest {

    @Test
    public void itPrintsResultMessage() {
        UnsuccessfulResult unit = new UnsuccessfulResult();
        PrintStream printStream = mock(PrintStream.class);

        unit.print(printStream);

        verify(printStream, times(1)).println("This ticket did not win a prize.");
    }
}