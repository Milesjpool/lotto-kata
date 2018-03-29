import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;


public class SmokeTest {

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
    public void itOutputsMetadata(){
        TicketPrizeCalculator.main(null);
        assertThat(outputStream.toString(), containsString("Miles Pool - Calculating Lottery Winners v1.0.0"));
    }

    @Test
    public void itNotifiesWhenATicketDoesNotWin(){
        String winningNumbers = "1,2,3";
        String ticketNumbers = "4,5,6";
        String[] args = new String[]{"LotteryName", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket did not win a prize."));
    }
}