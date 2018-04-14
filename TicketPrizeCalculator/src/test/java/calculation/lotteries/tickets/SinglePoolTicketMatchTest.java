package calculation.lotteries.tickets;

import calculation.lotteries.springlotto.SinglePoolTicketMatch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class SinglePoolTicketMatchTest {

    @Test
    public void itOutputsMatchesAsString(){
        SinglePoolTicketMatch unit = new SinglePoolTicketMatch();
        unit.addMatch(5);
        unit.addMatch(10);

        assertThat(unit.toString(), equalTo("the numbers 5, 10 from pool 1"));
    }

    @Test
    public void itOutputsPoolIdAsString(){
        int poolId = 5;
        SinglePoolTicketMatch unit = new SinglePoolTicketMatch(poolId, 1);
        unit.addMatch(5);
        unit.addMatch(10);

        assertThat(unit.toString(), equalTo("the numbers 5, 10 from pool " + poolId));
    }

    @Test
    public void itOutputsSingularMatchAsString(){
        SinglePoolTicketMatch unit = new SinglePoolTicketMatch();
        unit.addMatch(5);

        assertThat(unit.toString(), equalTo("the number 5 from pool 1"));
    }

    @Test
    public void itOutputsNoMatchesAsString(){
        SinglePoolTicketMatch unit = new SinglePoolTicketMatch();

        assertThat(unit.toString(), equalTo("no numbers from pool 1"));
    }

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