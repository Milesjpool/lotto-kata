package calculation.lotteries.springlotto;

import calculation.lotteries.LotteryResult;
import calculation.lotteries.LotteryTicket;

public class SpringLotto implements Lottery {
    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        return new SpringLottoWin(3);
    }
}
