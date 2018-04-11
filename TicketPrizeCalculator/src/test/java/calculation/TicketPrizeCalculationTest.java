package calculation;

import calculation.lotteries.LotteryPrize;
import calculation.lotteries.LotteryRegistry;
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
    private final LotteryPrize lotteryPrize = mock(LotteryPrize.class);
    private final ArgumentParser argumentParser = mock(ArgumentParser.class);
    private final String[] args = new String[0];

    @Test
    public void itReturnsInvalidArgumentsResult() throws InvalidArgumentException {
        when(argumentParser.getLotteryName(args)).thenThrow(InvalidArgumentException.class);

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args, lotteryRegistry, argumentParser);

        Printable expected = CalculationResults.invalidArguments;

        assertThat(unit.execute(), equalTo(expected));
    }

    @Test
    public void itReturnsLotteryRegistryResult() throws InvalidArgumentException {
        String lotteryName = "myLottery";

        when(argumentParser.getLotteryName(args)).thenReturn(lotteryName);
        when(lotteryRegistry.getLotteryPrize(lotteryName)).thenReturn(lotteryPrize);

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args, lotteryRegistry, argumentParser);

        assertThat(unit.execute(), equalTo(lotteryPrize));
    }
}