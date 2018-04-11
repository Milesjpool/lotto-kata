import calculation.CalculationResult;
import io.Printable;

public class TicketPrizeCalculation {
    TicketPrizeCalculation(String[] args) {
    }

    Printable execute() {
        return new CalculationResult("This ticket did not win a prize.");
    }
}
