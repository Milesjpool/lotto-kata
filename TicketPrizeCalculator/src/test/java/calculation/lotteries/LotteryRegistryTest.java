package calculation.lotteries;

import calculation.lotteries.results.LotteryResult;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LotteryRegistryTest {

    private final String lotteryName = "My-Lotto";
    private final Lottery lottery = mock(Lottery.class);
    private final Lottery defaultLottery = mock(NullLottery.class);

    private final LotteryTicket lotteryTicket = mock(LotteryTicket.class);
    private final LotteryRegistry unit = new LotteryRegistry(defaultLottery);

    @Before
    public void setup(){
        unit.registerLottery(lotteryName, lottery);
    }

    @Test
    public void itReturnsPrizeForAKnownLottery() {

        when(lotteryTicket.getLotteryName()).thenReturn(lotteryName);

        LotteryResult expectedResult = mock(LotteryResult.class);
        when(lottery.evaluateTicket(lotteryTicket)).thenReturn(expectedResult);

        assertThat(unit.getLotteryPrize(lotteryTicket), equalTo(expectedResult));
    }

    @Test
    public void itReturnsPrizeForAKnownLottery_whenCasingDoesNotMatch() {
        unit.registerLottery(lotteryName.toLowerCase(), lottery);
        when(lotteryTicket.getLotteryName()).thenReturn(lotteryName.toUpperCase());

        LotteryResult expectedResult = mock(LotteryResult.class);
        when(lottery.evaluateTicket(lotteryTicket)).thenReturn(expectedResult);

        assertThat(unit.getLotteryPrize(lotteryTicket), equalTo(expectedResult));
    }

    @Test
    public void itReturnsUnrecognisedTicketForUnknownLottery() {
        String lotteryName = "WeirdLottery";

        when(lotteryTicket.getLotteryName()).thenReturn(lotteryName);

        LotteryResult expectedResult = mock(LotteryResult.class);
        when(defaultLottery.evaluateTicket(lotteryTicket)).thenReturn(expectedResult);


        assertThat(unit.getLotteryPrize(lotteryTicket), equalTo(expectedResult));
    }


}

