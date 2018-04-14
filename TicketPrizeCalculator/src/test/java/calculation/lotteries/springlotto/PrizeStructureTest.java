package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.tickets.TicketMatch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class PrizeStructureTest {

    @Test
    public void itReturnsRelevantPrizeForMatch() {
        PrizeStructure unit = new PrizeStructure();
        TicketMatch match = mock(TicketMatch.class);
        Prize prize = mock(Prize.class);
        unit.addPrize(match, prize);

        assertThat(unit.lookup(match).get(), equalTo(prize));
    }

    @Test
    public void itReturnsNull_whenNoPrizeForMatch() {
        PrizeStructure unit = new PrizeStructure();
        TicketMatch match = mock(TicketMatch.class);

        assertThat(unit.lookup(match).isPresent(), equalTo(false));
    }
}