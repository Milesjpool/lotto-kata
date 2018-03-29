package metadata;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ApplicationHeaderTest {

    @Test
    public void itContainsImplementerName() {
        ApplicationHeader unit = new ApplicationHeader();
        assertThat(unit.toString(), containsString("Miles Pool"));
    }

    @Test
    public void itContainsApplicationName() {
        ApplicationHeader unit = new ApplicationHeader();
        assertThat(unit.toString(), containsString("Calculating Lottery Winners v1.0.0"));
    }

    @Test
    public void itPrintsSelfToStream() {
        ApplicationHeader unit = new ApplicationHeader();
        PrintStream printStream = mock(PrintStream.class);

        unit.print(printStream);

        verify(printStream, times(1)).println(unit);
    }
}