package calculation.results;

import calculation.lotteries.LotteryResult;
import io.Printable;

public class CalculationResults {
    public static final LotteryResult unrecognisedTicket = new UnrecognisedTicket();
    public static final Printable invalidArguments = new InvalidArguments();
}
