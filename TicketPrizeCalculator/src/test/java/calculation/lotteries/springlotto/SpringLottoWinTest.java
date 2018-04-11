package calculation.lotteries.springlotto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpringLottoWinTest {

    @Test
    public void itIsNotEqualToDissimilarInstance(){
        SpringLottoWin unit = new SpringLottoWin(1);
        SpringLottoWin other = new SpringLottoWin(3);

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        SpringLottoWin unit = new SpringLottoWin(1);
        SpringLottoWin other = new SpringLottoWin(1);

        assertThat(unit, equalTo(other));
    }
}