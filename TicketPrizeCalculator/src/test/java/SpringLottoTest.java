import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class SpringLottoTest {

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
    public void itNotifies_whenATicketDoesNotWin(){
        String winningNumbers = "6,20,4,30,2,10";
        String ticketNumbers = "7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket did not win a prize."));
    }

    @Test
    public void itNotifies_whenATicketWins(){
        String winningNumbers = "7,20,4,35,1,12";
        String ticketNumbers = "7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket won a prize of class 3 and amount £300."));
        assertThat(outputStream.toString(), containsString("Matched the numbers 7, 35, 1, 12 from pool 1."));
    }

    @Test
    public void itNotifies_whenATicketWinsJackpot(){
        String winningNumbers = "7,4,20,35,1,12";
        String ticketNumbers = "7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket won a prize of class 1 and amount £500,000."));
        assertThat(outputStream.toString(), containsString("Matched the numbers 7, 4, 20, 35, 1, 12 from pool 1."));
    }

    @Test
    public void itNotifies_whenATicketIsInvalid(){
        String winningNumbers = "7,4,20,35,1,100";
        String ticketNumbers = "7,4,20,35,1,110";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket is malformed."));
    }
}
