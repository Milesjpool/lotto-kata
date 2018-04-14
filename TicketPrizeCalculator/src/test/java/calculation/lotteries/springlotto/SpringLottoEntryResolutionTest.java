package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.SinglePoolTicketMatch;
import calculation.lotteries.tickets.TicketMatch;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpringLottoEntryResolutionTest {

    private final PrizeStructure prizeStructure = mock(PrizeStructure.class);
    private final LotteryTicket entry = mock(LotteryTicket.class);
    private final Prize prize = mock(Prize.class);

    @Test
    public void itReturnsNoPrize_whenNoNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2});
        when(entry.getTicketNumbers()).thenReturn(new int[]{2,3});

        when(prizeStructure.lookup(new SinglePoolTicketMatch())).thenReturn(Optional.empty());
        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure, new SpringLottoTicketMatcher());


        assertThat(unit.getResult(entry), equalTo(LotteryResults.unsuccessfulTicket));
    }

    @Test
    public void itReturnsPrize_whenSomeNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2,4,5});
        when(entry.getTicketNumbers()).thenReturn(new int[]{1,2,3,5});

        TicketMatch ticketMatch = new SinglePoolTicketMatch(3);
        when(prizeStructure.lookup(ticketMatch)).thenReturn(Optional.of(prize));

        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure, new SpringLottoTicketMatcher());

        assertThat(unit.getResult(entry), equalTo(new SpringLottoWin(prize, ticketMatch)));
    }

    @Test
    public void itReturnsPrize_whenAllNumbersMatch(){
        when(entry.getWinningNumbers()).thenReturn(new int[]{1,2,3,4});
        when(entry.getTicketNumbers()).thenReturn(new int[]{1,2,3,4});

        TicketMatch ticketMatch = new SinglePoolTicketMatch(4);
        when(prizeStructure.lookup(ticketMatch)).thenReturn(Optional.of(prize));

        SpringLottoEntryResolution unit = new SpringLottoEntryResolution(prizeStructure, new SpringLottoTicketMatcher());

        assertThat(unit.getResult(entry), equalTo(new SpringLottoWin(prize, ticketMatch)));
    }
}