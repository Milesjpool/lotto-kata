package calculation.lotteries.javamillions;

import calculation.lotteries.springlotto.SinglePoolTicketMatch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TwoPoolTicketMatchTest {
    @Test
    public void itOutputsMatchesAsString(){
        String pool2Matches = "pool2 matches";
        String pool1Matches = "pool1 matches";

        SinglePoolTicketMatch pool1 = mock(SinglePoolTicketMatch.class);
        when(pool1.toString()).thenReturn(pool1Matches);
        SinglePoolTicketMatch pool2 = mock(SinglePoolTicketMatch.class);
        when(pool2.toString()).thenReturn(pool2Matches);

        TwoPoolTicketMatch unit = new TwoPoolTicketMatch(pool1,pool2);

        String expected = pool1Matches + " and " + pool2Matches;
        assertThat(unit.toString(), equalTo(expected));
    }

    @Test
    public void itDoesNotEqualDissimilarInstanceInPool1(){
        TwoPoolTicketMatch unit = new TwoPoolTicketMatch(1, 2);
        TwoPoolTicketMatch other = new TwoPoolTicketMatch(1, 10);
        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itDoesNotEqualDissimilarInstanceInPool2(){
        TwoPoolTicketMatch unit = new TwoPoolTicketMatch(10, 2);
        TwoPoolTicketMatch other = new TwoPoolTicketMatch(1, 2);
        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itEqualsSimilarInstance(){
        TwoPoolTicketMatch unit = new TwoPoolTicketMatch(1, 2);
        TwoPoolTicketMatch other = new TwoPoolTicketMatch(1, 2);
        assertThat(unit, equalTo(other));
    }
}