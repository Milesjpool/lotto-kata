package calculation;

import calculation.lotteries.springlotto.SpringLottoWin;
import calculation.results.CalculationResults;
import io.Printable;

public class TicketPrizeCalculation {
    private String[] args;

    public TicketPrizeCalculation(String[] args) {
        this.args = args;
    }

    public Printable execute() {
        if (args == null)
            return CalculationResults.invalidArguments;
        if (args[0].equals("SpringLotto"))
            return new SpringLottoWin(3);
        return CalculationResults.unrecognisedTicket;
    }
}

