package calculation;

import calculation.lotteries.LotteryPrize;
import calculation.lotteries.LotteryRegistry;
import calculation.results.CalculationResults;
import io.Printable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicketPrizeCalculationTest {

    private final LotteryRegistry lotteryRegistry = mock(LotteryRegistry.class);
    private final LotteryPrize lotteryPrize = mock(LotteryPrize.class);

    @Test
    public void itReturnsInvalidArgumentsResult() {
        String[] args = null;

        TicketPrizeCalculation unit = new TicketPrizeCalculation(args, lotteryRegistry);

        Printable expected = CalculationResults.invalidArguments;

        assertThat(unit.execute(), equalTo(expected));
    }

    @Test
    public void itReturnsLotteryRegistryResult() {
        String lotteryName = "myLottery";
        String[] args = new String[]{lotteryName, "1", "2"};

        when(lotteryRegistry.getLotteryPrize(lotteryName)).thenReturn(lotteryPrize);
        TicketPrizeCalculation unit = new TicketPrizeCalculation(args, lotteryRegistry);

        assertThat(unit.execute(), equalTo(lotteryPrize));
    }
}