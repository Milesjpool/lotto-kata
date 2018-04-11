package calculation;

import calculation.lotteries.springlotto.SpringLottoWin;

public class TicketPrizeCalculation {
    static final CalculationResult unrecognisedTicket = new UnrecognisedTicket();
    static final CalculationResult invalidArguments = new InvalidArguments();
    private String[] args;

    public TicketPrizeCalculation(String[] args) {
        this.args = args;
    }

    public CalculationResult execute() {
        if (args == null)
            return invalidArguments;
        if (args[0].equals("SpringLotto"))
            return new SpringLottoWin(3);
        return unrecognisedTicket;
    }
}
