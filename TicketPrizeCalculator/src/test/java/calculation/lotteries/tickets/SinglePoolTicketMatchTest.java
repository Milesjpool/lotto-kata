package calculation.lotteries.tickets;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class SinglePoolTicketMatchTest {

    @Test
    public void itIsEqualToSimilarInstance(){
        TicketMatch unit = new SinglePoolTicketMatch(3);
        TicketMatch other = new SinglePoolTicketMatch(3);

        assertThat(unit, equalTo(other));
    }

    @Test
    public void itIsNotEqualToDissimilarInstance(){
        TicketMatch unit = new SinglePoolTicketMatch(3);
        TicketMatch other = new SinglePoolTicketMatch(4);

        assertThat(unit, not(equalTo(other)));
    }
}