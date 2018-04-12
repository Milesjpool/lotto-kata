package calculation.lotteries.tickets.validation;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NumberSetLengthValidationTest {

    private final int ticketLength = 2;
    private final NumberSetLengthValidation unit = new NumberSetLengthValidation(ticketLength);

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooFewNumbers() {
        int[] numbers = new int[ticketLength - 1];

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itRejectsInvalidTickets_whenThereAreTooManyNumbers() {
        int[] numbers = new int[ticketLength + 1];

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itRejectsInvalidTickets_whenNumbersIsNull() {
        int[] numbers = null;

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itAllowsTickets_whenCriteriaAreMet() {
        int[] numbers = new int[ticketLength];

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(true));
    }
}
