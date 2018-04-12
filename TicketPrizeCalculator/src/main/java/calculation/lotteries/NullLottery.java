package calculation.lotteries;

import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.tickets.LotteryTicket;

public class NullLottery implements Lottery{
    public LotteryResult evaluateTicket(LotteryTicket lotteryTicket) {
        return LotteryResults.unrecognisedTicket;
    }
}