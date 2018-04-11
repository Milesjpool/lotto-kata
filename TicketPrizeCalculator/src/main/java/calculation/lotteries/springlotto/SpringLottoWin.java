package calculation.lotteries.springlotto;

import calculation.CalculationResult;

import java.util.Objects;

public class SpringLottoWin extends CalculationResult {
    private final int prizeClass;

    public SpringLottoWin(int prizeClass) {
        super(null);
        this.prizeClass = prizeClass;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prizeClass);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
                return false;
        if (!(obj instanceof SpringLottoWin))
                return false;
        SpringLottoWin o = (SpringLottoWin) obj;
        return o.prizeClass == this.prizeClass;
    }
}
