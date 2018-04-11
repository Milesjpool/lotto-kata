package calculation;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ArgumentParserTest {

    private final ArgumentParser unit = new ArgumentParser();

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenNotEnoughArgs() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery"};

        unit.getLotteryName(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenTooManyArgs() throws InvalidArgumentException {
        String[] args = new String[]{"my-lottery", "1", "2", "3"};

        unit.getLotteryName(args);
    }

    @Test(expected = InvalidArgumentException.class)
    public void itThrowsWhenNullArgs() throws InvalidArgumentException {
        String[] args = null;

        unit.getLotteryName(args);
    }

    @Test
    public void itReturnsFirstArgumentAsLotteryName() throws InvalidArgumentException {
        String expected = "my-lottery";
        String[] args = new String[]{expected, "1", "2"};

        String lotteryName = unit.getLotteryName(args);

        assertThat(lotteryName, equalTo(expected));
    }
}