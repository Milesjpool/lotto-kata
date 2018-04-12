package calculation.lotteries.tickets.validation;

public class NumberSetLengthValidation implements NumberSetValidation {
    private final int ticketLength;

    public NumberSetLengthValidation(int ticketLength) {
        this.ticketLength = ticketLength;
    }

    public boolean isValid(int[] numbers) {
        return numbers != null && numbers.length == ticketLength;
    }
}