package calculation.lotteries.tickets.validation;

public class NumberRangeValidation implements NumberSetValidation {
    private final int lowerBound;
    private final int upperBound;

    public NumberRangeValidation(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isValid(int[] numbers) {
        for (int num : numbers) {
            if (num < lowerBound || num > upperBound)
                return false;
        }
        return true;
    }
}