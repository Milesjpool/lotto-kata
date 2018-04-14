package calculation.lotteries.springlotto;

import calculation.lotteries.LotteryEntry;
import calculation.lotteries.Prize;
import calculation.lotteries.tickets.SinglePoolTicketMatch;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpringLottoEntryResolutionTest {

    private final PrizeStructure prizeStructure = mock(PrizeStructure.class);
    private final LotteryEntry entry = mock(LotteryEntry.class);
    private final Prize prize = mock(Prize.class);

    @Test
    public void itReturnsNoPrize_whenNoNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2});
        when(entry.getTicketNumbers()).thenReturn(new int[]{2,3});

        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure);
        assertThat(unit.resolve(entry).isPresent(), equalTo(false));
    }

    @Test
    public void itReturnsPrize_whenSomeNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2,4,5});
        when(entry.getTicketNumbers()).thenReturn(new int[]{1,2,3,5});

        when(prizeStructure.lookup(new SinglePoolTicketMatch(3))).thenReturn(prize);
        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure);

        assertThat(unit.resolve(entry).get(), equalTo(prize));
    }

    @Test
    public void itReturnsPrize_whenAllNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2,3,4});
        when(entry.getTicketNumbers()).thenReturn(new int[]{1,2,3,4});

        when(prizeStructure.lookup(new SinglePoolTicketMatch(4))).thenReturn(prize);
        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure);

        assertThat(unit.resolve(entry).get(), equalTo(prize));
    }
}