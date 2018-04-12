package calculation.lotteries.springlotto;

import calculation.lotteries.Lottery;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.LotteryTicket;
import calculation.lotteries.results.LotteryResults;

public class SpringLotto implements Lottery {

    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        if (ticket.getWinningNumbers().length != 6)
            return LotteryResults.malformedTicket;

        if (ticket.getTicketNumbers().length != 6)
            return LotteryResults.malformedTicket;


        Prize prize = new Prize(3, "300");
        return new SpringLottoWin(prize);
    }
}
