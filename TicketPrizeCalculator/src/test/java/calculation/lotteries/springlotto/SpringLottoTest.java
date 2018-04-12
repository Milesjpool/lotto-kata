package calculation.lotteries.springlotto;

import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.validation.NumberSetValidation;
import calculation.lotteries.results.LotteryResults;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpringLottoTest {

    private int[] winningNums = new int[]{7,20,4,35,1,12};
    private int[] ticketNums = new int[]{7,4,20,35,1,12};
    private final LotteryTicket ticket = mock(LotteryTicket.class);
    private final NumberSetValidation numberSetValidation = mock(NumberSetValidation.class);
    private final SpringLottoPrizeResolution springLottoPrizeResolution = mock(SpringLottoPrizeResolution.class);
    private final SpringLotto unit = new SpringLotto(numberSetValidation, springLottoPrizeResolution);

    @Before
    public void Setup() {
        when(ticket.getWinningNumbers()).thenReturn(winningNums);
        when(ticket.getTicketNumbers()).thenReturn(ticketNums);
    }

    @Test
    public void itRejectsTicket_withInvalidWinningNumbers(){
        when(numberSetValidation.isValid(winningNums)).thenReturn(false);
        when(numberSetValidation.isValid(ticketNums)).thenReturn(true);
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

    @Test
    public void itRejectsTicket_withInvalidTicketNumbers(){
        when(numberSetValidation.isValid(winningNums)).thenReturn(true);
        when(numberSetValidation.isValid(ticketNums)).thenReturn(false);
        unit.evaluateTicket(ticket);

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.malformedTicket));
    }

    @Test
    public void itReturnsAResult_whenAPrizeIsNotAwarded(){
        when(numberSetValidation.isValid(any())).thenReturn(true);
        when(springLottoPrizeResolution.resolve(winningNums, ticketNums)).thenReturn(Optional.empty());

        assertThat(unit.evaluateTicket(ticket), equalTo(LotteryResults.unsuccessfulTicket));
    }
}
