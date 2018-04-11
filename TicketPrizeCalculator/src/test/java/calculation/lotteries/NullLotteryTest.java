package calculation.lotteries;

import calculation.lotteries.results.LotteryResults;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

public class NullLotteryTest {

    @Test
    public void itEvaluatesToUnrecognisedTicket() {
        NullLottery unit = new NullLottery();

        LotteryTicket ticket = mock(LotteryTicket.class);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.unrecognisedTicket));
    }
}