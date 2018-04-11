package calculation.lotteries;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LotteryTicketTest {
    @Test
    public void itIsNotEqualToDissimilarInstance(){
        LotteryTicket unit = new LotteryTicket("lotto");
        LotteryTicket other = new LotteryTicket("not-lotto");

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        LotteryTicket unit = new LotteryTicket("lotto");
        LotteryTicket other = new LotteryTicket("lotto");

        assertThat(unit, equalTo(other));
    }
}