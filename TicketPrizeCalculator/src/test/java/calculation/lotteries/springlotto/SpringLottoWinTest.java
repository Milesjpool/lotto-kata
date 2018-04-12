package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import io.Printable;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

public class SpringLottoWinTest {


    @Test
    public void itOutputsWinnings() {

        int prizeClass = 3;
        int winnings = 300;
        String expectedMessage =
                "This ticket won a prize of class " + prizeClass + " and amount £" + winnings + ".";

        Printable unit = new SpringLottoWin(new Prize(prizeClass, "300"));

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }

    @Test
    public void itOutputsWinningNumbers() {

        String expectedMessage =
                "Matched the numbers 7, 35, 1, 12 from pool 1.";

        Printable unit = new SpringLottoWin(new Prize(3, "300"));

        PrintStream printStream = mock(PrintStream.class);
        unit.print(printStream);

        verify(printStream, times(1)).println(expectedMessage);
    }

    @Test
    public void itIsNotEqualToDissimilarInstance(){
        SpringLottoWin unit = new SpringLottoWin(new Prize(1, "300"));
        SpringLottoWin other = new SpringLottoWin(new Prize(3, "300"));

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        Prize prize = new Prize(1, "300");
        SpringLottoWin unit = new SpringLottoWin(prize);
        SpringLottoWin other = new SpringLottoWin(prize);

        assertThat(unit, equalTo(other));
    }
}