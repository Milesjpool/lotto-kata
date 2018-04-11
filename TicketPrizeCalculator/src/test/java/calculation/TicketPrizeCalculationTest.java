package calculation;

import calculation.lotteries.LotteryPrize;
import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.LotteryTicket;
import calculation.results.CalculationResults;
import com.sun.javaws.exceptions.InvalidArgumentException;
import io.Printable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketPrizeCalculationTest {

    private final LotteryRegistry lotteryRegistry = mock(LotteryRegistry.class);
    private final LotteryTicketParser argumentParser = mock(LotteryTicketParser.class);

    private final String[] args = new String[0];
    private final LotteryTicket lotteryticket = mock(LotteryTicket.class);
    private final LotteryPrize lotteryPrize = mock(LotteryPrize.class);

    @Test
    public void itReturnsInvalidArgumentsResult() throws InvalidArgumentException {
        when(argumentParser.parse(args)).thenThrow(InvalidArgumentException.class);

        TicketPrizeCalculation unit = new TicketPrizeCalculation(lotteryRegistry, argumentParser);

        Printable expected = CalculationResults.invalidArguments;

        assertThat(unit.calculate(args), equalTo(expected));
    }

    @Test
    public void itReturnsLotteryRegistryResult() throws InvalidArgumentException {

        when(argumentParser.parse(args)).thenReturn(lotteryticket);
        when(lotteryRegistry.getLotteryPrize(lotteryticket)).thenReturn(lotteryPrize);

        TicketPrizeCalculation unit = new TicketPrizeCalculation(lotteryRegistry, argumentParser);

        assertThat(unit.calculate(args), equalTo(lotteryPrize));
    }
}