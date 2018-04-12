package calculation.lotteries.tickets.validation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NoDuplicateNumbersValidationTest {

    private final NoDuplicateNumbersValidation unit = new  NoDuplicateNumbersValidation();

    @Test
    public void itRejectsInvalidTickets_whenANumberIsDuplicated(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 1};

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itAllowsTicket_whenCriteriaIsMet(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(true));
    }
}
