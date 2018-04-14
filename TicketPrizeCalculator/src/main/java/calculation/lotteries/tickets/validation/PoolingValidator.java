package calculation.lotteries.tickets.validation;

import java.util.Arrays;

public class PoolingValidator implements NumberSetValidation {
    private final int pool1Size;
    private final NumberSetValidation pool1Validator;
    private final int pool2Size;
    private final NumberSetValidation pool2Validator;

    public PoolingValidator(int pool1Size, NumberSetValidation pool1Validator, int pool2Size, NumberSetValidation pool2Validator) {
        this.pool1Size = pool1Size;
        this.pool1Validator = pool1Validator;

        this.pool2Size = pool2Size;
        this.pool2Validator = pool2Validator;
    }

    @Override
    public boolean isValid(int[] numbers) {
        if (numbers.length != (pool1Size + pool2Size))
            return false;
        int[] pool1 = Arrays.copyOfRange(numbers, 0, pool1Size);
        int[] pool2 = Arrays.copyOfRange(numbers, pool1Size, pool1Size+pool2Size);
        return pool1Validator.isValid(pool1) && pool2Validator.isValid(pool2);
    }
}
