package calculation.lotteries.springlotto;

import calculation.lotteries.LotteryTicket;
import calculation.lotteries.results.LotteryResults;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpringLottoTest {

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooFewWinningNumbers(){
        SpringLotto unit = new SpringLotto();
        LotteryTicket ticket = new LotteryTicket("SL", new int[]{1}, new int[]{1,2,3,4,5,6});
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooFewTicketNumbers(){
        SpringLotto unit = new SpringLotto();
        LotteryTicket ticket = new LotteryTicket("SL", new int[]{1,2,3,4,5,6}, new int[]{1});
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooManyWinningNumbers(){
        SpringLotto unit = new SpringLotto();
        LotteryTicket ticket = new LotteryTicket("SL", new int[]{1,2,3,4,5,6,7}, new int[]{1,2,3,4,5,6});
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooManyTicketNumbers(){
        SpringLotto unit = new SpringLotto();
        LotteryTicket ticket = new LotteryTicket("SL", new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6,7});
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

}