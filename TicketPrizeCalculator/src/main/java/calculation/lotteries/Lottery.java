package calculation.lotteries;

import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.tickets.LotteryTicket;

public interface Lottery {
    LotteryResult evaluateTicket(LotteryTicket ticket);
}
