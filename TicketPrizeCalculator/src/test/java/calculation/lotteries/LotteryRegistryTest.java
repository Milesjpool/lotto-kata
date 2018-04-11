package calculation.lotteries;

import calculation.lotteries.springlotto.SpringLottoWin;
import calculation.results.CalculationResults;
import io.Printable;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LotteryRegistryTest {

    @Test
    public void itReturnsPrizeForAKnownLottery() {
        String lotteryName = "SpringLotto";

        LotteryRegistry unit = new LotteryRegistry();

        Printable expected = new SpringLottoWin(3);

        assertThat(unit.getLotteryPrize(lotteryName), equalTo(expected));
    }

    @Test
    public void itReturnsUnrecognisedTicketForUnknownLottery() {
        String lotteryName = "WeirdLottery";

        LotteryRegistry unit = new LotteryRegistry();

        Printable expected = CalculationResults.unrecognisedTicket;

        assertThat(unit.getLotteryPrize(lotteryName), equalTo(expected));
    }
}

