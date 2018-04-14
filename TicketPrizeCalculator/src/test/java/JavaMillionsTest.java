import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class JavaMillionsTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setup(){
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void teardown(){
        System.setOut(System.out);
    }

    @Test
    @Ignore("WIP")
    public void itNotifies_whenATicketDoesNotWin(){
        String winningNumbers = "1,2,3,4,5,1";
        String ticketNumbers = "6,7,8,9,10,2";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket did not win a prize."));
    }
}
