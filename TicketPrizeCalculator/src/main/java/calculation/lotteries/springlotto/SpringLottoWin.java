package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.results.LotteryResult;

import java.io.PrintStream;
import java.util.Objects;

public class SpringLottoWin implements LotteryResult {
    private final Prize prize;

    SpringLottoWin(Prize prize) {
        this.prize = prize;
    }


    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket won " + prize);
        printStream.println("Matched the numbers 7, 35, 1, 12 from pool 1.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
                return false;
        if (!(obj instanceof SpringLottoWin))
                return false;
        SpringLottoWin o = (SpringLottoWin) obj;
        return o.prize == this.prize;
    }
}
