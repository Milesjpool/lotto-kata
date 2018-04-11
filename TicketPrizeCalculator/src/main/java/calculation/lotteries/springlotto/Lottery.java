package calculation.lotteries.springlotto;

import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.LotteryTicket;

public interface Lottery {
    LotteryResult evaluateTicket(LotteryTicket ticket);
}
