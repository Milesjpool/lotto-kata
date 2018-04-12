package calculation.lotteries.tickets;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LotteryTicketTest {
    @Test
    public void itIsNotEqualToInstance_withDissimilarName(){
        LotteryTicket unit = new LotteryTicket("lotto", new int[]{1}, new int[]{1});
        LotteryTicket other = new LotteryTicket("not-lotto", new int[]{1}, new int[]{1});

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsNotEqualToInstance_withDissimilarWinningNumbers(){
        LotteryTicket unit = new LotteryTicket("lotto", new int[]{1}, new int[]{1});
        LotteryTicket other = new LotteryTicket("lotto", new int[]{9999}, new int[]{1});

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsNotEqualToInstance_withDissimilarTicketNumbers(){
        LotteryTicket unit = new LotteryTicket("lotto", new int[]{1}, new int[]{1});
        LotteryTicket other = new LotteryTicket("lotto", new int[]{1}, new int[]{9999});

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        LotteryTicket unit = new LotteryTicket("lotto", new int[]{1}, new int[]{1});
        LotteryTicket other = new LotteryTicket("lotto", new int[]{1}, new int[]{1});

        assertThat(unit, equalTo(other));
    }
}