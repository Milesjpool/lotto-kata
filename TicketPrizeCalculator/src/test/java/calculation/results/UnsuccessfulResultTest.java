package calculation.results;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UnsuccessfulResultTest {

    @Test
    public void itHasAResultMessage() {
        CalculationResult unit = new UnsuccessfulResult();

        assertThat(unit.getMessage(), equalTo("This ticket did not win a prize."));
    }
}
