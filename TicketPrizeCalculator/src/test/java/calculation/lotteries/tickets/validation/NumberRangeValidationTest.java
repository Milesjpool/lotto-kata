package calculation.lotteries.tickets.validation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NumberRangeValidationTest {

    private final int lowerBound = 1;
    private final int upperBound = 10;
    private final NumberRangeValidation unit = new NumberRangeValidation(lowerBound, upperBound);

    @Test
    public void itRejectsInvalidTickets_whenANumberIsTooSmall(){
        int[] numbers = {lowerBound - 1, 2};

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itRejectsInvalidTickets_whenANumberIsTooLarge(){
        int[] numbers = {1, upperBound + 1};

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itAllowsTickets_whenCriteriaAreMet(){
        int[] numbers = {1, 2};

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(true));
    }
}
