package calculation;

import calculation.lotteries.LotteryTicket;
import io.InvalidArgumentException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LotteryTicketParserTest {

    private final LotteryNumberParser lotteryNumberParser = mock(LotteryNumberParser.class);
    private final LotteryTicketParser unit = new LotteryTicketParser(lotteryNumberParser);

    @Test(expected = InvalidArgumentException.class)
    public void itThrows_whenArgsIsTooShort() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery"};

        unit.parse(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrows_whenArgsIsTooLong() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery", "1", "2", "3"};

        unit.parse(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrows_whenArgsIsNull() throws InvalidArgumentException {
        String[] args = null;

        unit.parse(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrows_whenNumbersAreNotParseable() throws InvalidArgumentException {
        String invalidNums = "abc";

        when(lotteryNumberParser.getNumbers(invalidNums)).thenThrow(NumberFormatException.class);
        String[] args = new String[]{"my-lottery", invalidNums, "2"};

        unit.parse(args);
    }

    @Test
    public void itReturnsLotteryTicket() throws InvalidArgumentException {
        String lotteryName = "my-lottery";

        String winningNumbersArg = "1,2";
        int[] winningNumbers = {1, 2};
        when(lotteryNumberParser.getNumbers(winningNumbersArg)).thenReturn(winningNumbers);

        String ticketNumbersArg = "2,3";
        int[] ticketNumbers = {2, 3};
        when(lotteryNumberParser.getNumbers(ticketNumbersArg)).thenReturn(ticketNumbers);

        LotteryTicket expected = new LotteryTicket(lotteryName, winningNumbers, ticketNumbers);
        String[] args = new String[]{lotteryName, winningNumbersArg, ticketNumbersArg};

        LotteryTicket ticket = unit.parse(args);

        assertThat(ticket, equalTo(expected));
    }
}