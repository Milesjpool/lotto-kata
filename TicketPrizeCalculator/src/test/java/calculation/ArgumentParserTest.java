package calculation;

import calculation.lotteries.LotteryTicket;
import io.InvalidArgumentException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ArgumentParserTest {

    private final LotteryTicketParser unit = new LotteryTicketParser();

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenNotEnoughArgs() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery"};

        unit.parse(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenTooManyArgs() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery", "1", "2", "3"};

        unit.parse(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenNullArgs() throws InvalidArgumentException {
        String[] args = null;

        unit.parse(args);
    }

    @Test
    public void itReturnsLotteryTicket() throws InvalidArgumentException {
        String lotteryName = "my-lottery";
        LotteryTicket expected = new LotteryTicket(lotteryName);
        String[] args = new String[]{lotteryName, "1", "2"};

        LotteryTicket ticket = unit.parse(args);

        assertThat(ticket, equalTo(expected));
    }
}