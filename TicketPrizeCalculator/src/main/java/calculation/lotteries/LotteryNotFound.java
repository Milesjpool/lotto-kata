package calculation.lotteries;

import calculation.lotteries.springlotto.Lottery;
import calculation.results.CalculationResults;

public class LotteryNotFound implements Lottery{
    public LotteryResult evaluateTicket(LotteryTicket lotteryTicket) {
        return CalculationResults.unrecognisedTicket;
    }
}