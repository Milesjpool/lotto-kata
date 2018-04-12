package calculation.lotteries.tickets.validation;

public class ChainedNumberSetValidation implements NumberSetValidation {

    private NumberSetValidation[] validations;

    public ChainedNumberSetValidation(NumberSetValidation... validations) {

        this.validations = validations;
    }

    public boolean isValid(int[] numbers) {
        for ( NumberSetValidation validation : validations) {
            if (!validation.isValid(numbers))
                return false;
        }
        return true;
    }
}