package calculation.lotteries.javamillions;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TwoPoolTicketMatchTest {
    @Test
    public void itOutputsMatchesAsString(){
        TwoPoolTicketMatch unit = new TwoPoolTicketMatch();

        unit.addMatch(1, 1);
        unit.addMatch(1, 2);
        unit.addMatch(2, 3);
        String expected = "the numbers 1, 2 from pool 1 and the number 3 from pool 2";
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