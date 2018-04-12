package calculation.lotteries;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PrizeTest {

    @Test
    public void itIsDescribedInToString(){
        Prize unit = new Prize(1, "300");
        assertThat(unit.toString(), equalTo("a prize of class 1 and amount £300."));
    }

    @Test
    public void itIsNotEqualToInstance_withDisimilarPrizeClass(){
        Prize unit = new Prize(1, "300");
        Prize other = new Prize(3, "300");

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsNotEqualToInstance_withDisimilarPrizeMoney(){
        Prize unit = new Prize(1, "300");
        Prize other = new Prize(1, "500");

        assertThat(unit, not(equalTo(other)));
    }

    @Test
    public void itIsEqualToSimilarInstance(){
        Prize unit = new Prize(1, "300");
        Prize other = new Prize(1, "300");

        assertThat(unit, equalTo(other));
    }

}