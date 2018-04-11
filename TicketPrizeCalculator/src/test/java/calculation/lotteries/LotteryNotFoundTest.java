package calculation.lotteries;

import calculation.results.CalculationResults;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

public class LotteryNotFoundTest {

    @Test
    public void itEvaluatesToUnrecognisedTicket() {
        LotteryNotFound unit = new LotteryNotFound();

        LotteryTicket ticket = mock(LotteryTicket.class);

        assertThat(unit.evaluateTicket(ticket), equalTo(CalculationResults.unrecognisedTicket));
    }
}