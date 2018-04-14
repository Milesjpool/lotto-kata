package calculation.lotteries.javamillions;

import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketMatch;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JavaMillionsTicketMatcherTest {

    private LotteryTicket ticket = mock(LotteryTicket.class);

    @Test
    public void itReturnsEmptyMatch_whenNoNumbersMatch() {
        JavaMillionsTicketMatcher unit = new JavaMillionsTicketMatcher();

        when(ticket.getWinningNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        when(ticket.getTicketNumbers()).thenReturn(new int[]{12, 11, 10, 9, 8, 7});

        TicketMatch match = unit.getMatch(ticket);
        assertThat(match, equalTo(new TwoPoolTicketMatch(0, 0)));
    }

    @Test
    public void itMatchesAFullSecondPool() {
        JavaMillionsTicketMatcher unit = new JavaMillionsTicketMatcher();

        when(ticket.getWinningNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        when(ticket.getTicketNumbers()).thenReturn(new int[]{6, 7, 8, 9, 10, 6});

        TicketMatch match = unit.getMatch(ticket);
        assertThat(match, equalTo(new TwoPoolTicketMatch(0, 1)));
    }

    @Test
    public void itMatchesAFullFirstPool() {
        JavaMillionsTicketMatcher unit = new JavaMillionsTicketMatcher();

        when(ticket.getWinningNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        when(ticket.getTicketNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 1});

        TicketMatch match = unit.getMatch(ticket);
        assertThat(match, equalTo(new TwoPoolTicketMatch(5, 0)));
    }

    @Test
    public void itMatchesAnOrderedJackpot() {
        JavaMillionsTicketMatcher unit = new JavaMillionsTicketMatcher();

        when(ticket.getWinningNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        when(ticket.getTicketNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});

        TicketMatch match = unit.getMatch(ticket);
        assertThat(match, equalTo(new TwoPoolTicketMatch(5, 1)));
    }

    @Test
    public void itMatchesADisorderedJackpot() {
        JavaMillionsTicketMatcher unit = new JavaMillionsTicketMatcher();

        when(ticket.getWinningNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5, 6});
        when(ticket.getTicketNumbers()).thenReturn(new int[]{5, 4, 3, 2, 1, 6});

        TicketMatch match = unit.getMatch(ticket);
        assertThat(match, equalTo(new TwoPoolTicketMatch(5, 1)));
    }
}