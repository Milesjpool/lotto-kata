package calculation.lotteries.tickets.validation;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PoolingValidatorTest {

    private final NumberSetValidation pool1Validator = mock(NumberSetValidation.class);
    private final NumberSetValidation pool2Validator = mock(NumberSetValidation.class);
    private int pool1Size = 3;
    private int pool2Size = 2;
    private int[] numbers = new int[]{1,2,3,4,5};


    @Before
    public void setup(){
        when(pool1Validator.isValid(new int[]{1,2,3})).thenReturn(true);
        when(pool2Validator.isValid(new int[]{4,5})).thenReturn(true);
    }

    @Test
    public void itIsInvalid_whenSetIsLongerThanBothPools() {
        PoolingValidator unit = new PoolingValidator(pool1Size, pool1Validator, pool2Size, pool2Validator);
        boolean valid = unit.isValid(new int[pool1Size + pool2Size + 1]);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itIsInvalid_whenSetIsShorterThanBothPools() {
        PoolingValidator unit = new PoolingValidator(pool1Size, pool1Validator, pool2Size, pool2Validator);
        boolean valid = unit.isValid(new int[pool1Size + pool2Size - 1]);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itIsInvalid_whenFirstPoolIsInvalid() {
        PoolingValidator unit = new PoolingValidator(pool1Size, pool1Validator, pool2Size, pool2Validator);

        when(pool1Validator.isValid(new int[]{1,2,3})).thenReturn(false);

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }

    @Test
    public void itIsInvalid_whenFirstSecondIsInvalid() {
        PoolingValidator unit = new PoolingValidator(pool1Size, pool1Validator, pool2Size, pool2Validator);

        when(pool2Validator.isValid(new int[]{4,5})).thenReturn(false);

        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(false));
    }


    @Test
    public void itIsValid_whenBothPoolsAreValid() {
        PoolingValidator unit = new PoolingValidator(pool1Size, pool1Validator, pool2Size, pool2Validator);
        boolean valid = unit.isValid(numbers);

        assertThat(valid, equalTo(true));
    }
}