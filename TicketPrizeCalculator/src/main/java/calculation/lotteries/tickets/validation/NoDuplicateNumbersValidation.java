package calculation.lotteries.tickets.validation;

public class NoDuplicateNumbersValidation implements NumberSetValidation {
    public boolean isValid(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j])
                    return false;
            }
        }
        return true;
    }
}