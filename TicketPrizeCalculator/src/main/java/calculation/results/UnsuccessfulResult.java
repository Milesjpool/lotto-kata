package calculation.results;

public class UnsuccessfulResult implements CalculationResult {
    public String getMessage() {
        return "This ticket did not win a prize.";
    }
}