package calculation.lotteries.springlotto;

import calculation.lotteries.Lottery;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.LotteryTicket;

public class SpringLotto implements Lottery {

    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        Prize prize = new Prize(3, "300");
        return new SpringLottoWin(prize);
    }
}
