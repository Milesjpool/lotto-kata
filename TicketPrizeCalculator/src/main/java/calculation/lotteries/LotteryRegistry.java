package calculation.lotteries;

import calculation.lotteries.springlotto.SpringLottoWin;
import calculation.results.CalculationResults;
import io.Printable;

public class LotteryRegistry {
    public Printable getLotteryPrize(String lotteryName) {
        if (lotteryName.equals("SpringLotto"))
            return new SpringLottoWin(3);
        return CalculationResults.unrecognisedTicket;
    }
}
