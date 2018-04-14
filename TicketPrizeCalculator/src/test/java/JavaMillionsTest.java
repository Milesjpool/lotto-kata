import org.junit.After;
import org.junit.Before;
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
    public void itNotifies_whenATicketDoesNotWin(){
        String winningNumbers = "1,2,3,4,5,1";
        String ticketNumbers = "6,7,8,9,10,2";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket did not win a prize."));
    }

    @Test
    public void itNotifies_whenATicketWins(){
        String winningNumbers = "1,2,3,4,5,1";
        String ticketNumbers = "10,9,5,15,2,1";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket won a prize of class 7 and amount £5."));
        assertThat(outputStream.toString(), containsString("Matched the numbers 2, 5 from pool 1 and the number 1 from pool 2."));
    }

    @Test
    public void itNotifies_whenATicketWinsAJackpot(){
        String winningNumbers = "1,2,3,4,5,1";
        String ticketNumbers = "1,2,3,4,5,1";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket won a prize of class 1 and amount £10,000,000."));
        assertThat(outputStream.toString(), containsString("Matched the numbers 1, 2, 3, 4, 5 from pool 1 and the number 1 from pool 2."));
    }

    @Test
    public void itNotifies_whenANumberIsDuplicatedInPool1(){
        String winningNumbers = "2,2,3,4,5,1";
        String ticketNumbers = "6,7,8,9,10,2";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket is malformed."));
    }

    @Test
    public void itNotifies_whenATicketIsOutOfRangeInPool1(){
        String winningNumbers = "1,2,3,4,50,1";
        String ticketNumbers = "6,7,8,9,10,2";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket is malformed."));
    }

    @Test
    public void itNotifies_whenATicketIsOutOfRangeInPool2(){
        String winningNumbers = "1,2,3,4,5,1";
        String ticketNumbers = "6,7,8,9,10,10";
        String[] args = new String[]{"JavaMillions", winningNumbers, ticketNumbers};

        TicketPrizeCalculator.main(args);

        assertThat(outputStream.toString(), containsString("This ticket is malformed."));
    }
}
