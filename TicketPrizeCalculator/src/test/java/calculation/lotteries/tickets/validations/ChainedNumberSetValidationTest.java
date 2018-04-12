package calculation.lotteries.tickets.validations;

import calculation.lotteries.tickets.validation.ChainedNumberSetValidation;
import calculation.lotteries.tickets.validation.NumberSetValidation;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChainedNumberSetValidationTest {

    private NumberSetValidation a = mock(NumberSetValidation.class);
    private NumberSetValidation b = mock(NumberSetValidation.class);
    private NumberSetValidation c = mock(NumberSetValidation.class);
    private final ChainedNumberSetValidation unit = new ChainedNumberSetValidation(a, b, c);

    private final int[] numbers = new int[1];

    @Test
    public void itRejectsInvalidTickets_whenAnyValidationFails(){
        when(a.isValid(numbers)).thenReturn(true);
        when(b.isValid(numbers)).thenReturn(false);
        when(c.isValid(numbers)).thenReturn(true);

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itAllowsTickets_whenCriteriaAreMet(){
        when(a.isValid(numbers)).thenReturn(true);
        when(b.isValid(numbers)).thenReturn(true);
        when(c.isValid(numbers)).thenReturn(true);

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(true));
    }
}
