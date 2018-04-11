package calculation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LotteryNumberParserTest {

    @Test
    public void itParsesSingleNumberToArray() {
        LotteryNumberParser unit = new LotteryNumberParser();

        assertThat(unit.getNumbers("123"), equalTo(new int[]{123}));
    }

    @Test
    public void itParsesCommaSeparatedNumbersToArray() {
        LotteryNumberParser unit = new LotteryNumberParser();

        assertThat(unit.getNumbers("123,456"), equalTo(new int[]{123, 456}));
    }

    @Test
    public void itParsesCommaSeparatedNumbersToArray_whenNumbersHaveSpaces() {
        LotteryNumberParser unit = new LotteryNumberParser();

        assertThat(unit.getNumbers("123, 456, 789"), equalTo(new int[]{123, 456, 789}));
    }

    @Test(expected = NumberFormatException.class)
    public void itThrows_whenNumbersAreNotValid() {
        LotteryNumberParser unit = new LotteryNumberParser();

        unit.getNumbers("123, abc, 789");
    }
}