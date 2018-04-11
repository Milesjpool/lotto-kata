package calculation;

public class InvalidArguments extends CalculationResult {
    public InvalidArguments() {
        super("Arguments should be of the form: <lottery-name> <winning-numbers> <ticket-numbers>");
    }
}
