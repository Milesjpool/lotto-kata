package calculation.lotteries.springlotto;

import calculation.lotteries.prizes.Prize;
import calculation.lotteries.results.LotteryWin;
import calculation.lotteries.tickets.TicketMatch;
import io.Printable;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

public class LotteryWinTest {


    private final Prize prize = mock(Prize.class);
    private final TicketMatch match = mock(TicketMatch.class);

    @Test
    public void itOutputsWinnings() {

        String prizeMessage = "prize message";
        String expectedMessage = "This ticket won " + prizeMessage + ".";

        when(prize.toString()).thenReturn(prizeMessage);

        Printable unit = new LotteryWin(prize, match);

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }

    @Test
    public void itOutputsWinningNumbers() {

        String matchMessage = "prize message";
        String expectedMessage = "Matched " + matchMessage + ".";

        when(match.toString()).thenReturn(matchMessage);

        Printable unit = new LotteryWin(prize, match);

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }

    @Test
    public void itIsNotEqualToDissimilarPrize(){
        LotteryWin unit = new LotteryWin(new Prize(1, "300"), match);
        LotteryWin other = new LotteryWin(new Prize(3, "300"), match);

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsNotEqualToDissimilarMatch(){
        LotteryWin unit = new LotteryWin(prize, new SinglePoolTicketMatch(1));
        LotteryWin other = new LotteryWin(prize, new SinglePoolTicketMatch(3));

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        LotteryWin unit = new LotteryWin(prize, match);
        LotteryWin other = new LotteryWin(prize, match);

        assertThat(unit, equalTo(other));
    }
}