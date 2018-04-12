import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
    public void itOutputsInvalidArguments_WhenArgsAreNull(){
        TicketPrizeCalculator.main(null);
        assertThat(outputStream.toString(), containsString("Arguments should be of the form:"));
        assertThat(outputStream.toString(), containsString("<lottery-name> <winning-numbers> <ticket-numbers>"));
    }

    @Test
    public void itOutputsInvalidArguments_WhenIncorrectNumberOfArgs(){
        TicketPrizeCalculator.main(new String[]{"LotteryName"});
        assertThat(outputStream.toString(), containsString("Arguments should be of the form:"));
        assertThat(outputStream.toString(), containsString("<lottery-name> <winning-numbers> <ticket-numbers>"));
    }

    @Test
    public void itNotifiesWhenATicketDoesNotMatchAKnownLottery(){
        String winningNumbers = "1,2,3";
        String ticketNumbers = "4,5,6";
        String[] args = new String[]{"LotteryName", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This is not a recognised ticket."));
    }

    @Test
    @Ignore("Work in progress")
    public void itNotifiesWhenATicketDoesNotWinSpringLotto(){
        String winningNumbers = "6,20,4,30,2,10";
        String ticketNumbers = "7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket did not win a prize."));
    }

    @Test
    public void itNotifiesWhenATicketWinsSpringLotto(){
        String winningNumbers = "7,20,4,35,1,12";
        String ticketNumbers = "7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket won a prize of class 3 and amount £300."));
        assertThat(outputStream.toString(), containsString("Matched the numbers 7, 35, 1, 12 from pool 1."));
    }
}