package calculation;

import calculation.lotteries.springlotto.SpringLottoWin;
import calculation.results.CalculationResults;
import io.Printable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicketPrizeCalculationTest {

    @Test
    public void itReturnsInvalidArgumentsResult() {
        String[] args = null;

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args);

        Printable expected = CalculationResults.invalidArguments;

        assertThat(unit.execute(), equalTo(expected));
    }

    @Test
    public void itReturnsUnrecognisedTicketResult() {
        String[] args = new String[]{"WeirdLottery"};

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args);

        Printable expected = CalculationResults.unrecognisedTicket;

        assertThat(unit.execute(), equalTo(expected));
    }

    @Test
    public void itReturnsAWinningResult() {
        String winningNumbers = "“7,20,4,35,1,12";
        String ticketNumbers = "“7,4,20,35,1,12";
        String[] args = new String[]{"SpringLotto", winningNumbers, ticketNumbers};

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args);

        Printable expected = new SpringLottoWin(3);

        assertThat(unit.execute(), equalTo(expected));
    }
}