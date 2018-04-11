package calculation.lotteries;

import calculation.lotteries.results.LotteryResult;

public interface Lottery {
    LotteryResult evaluateTicket(LotteryTicket ticket);
}
