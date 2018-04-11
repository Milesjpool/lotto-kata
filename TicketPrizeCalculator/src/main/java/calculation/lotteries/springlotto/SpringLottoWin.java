package calculation.lotteries.springlotto;

import io.Printable;

import java.io.PrintStream;
import java.util.Objects;

public class SpringLottoWin implements Printable {
    private final int prizeClass;

    public SpringLottoWin(int prizeClass) {
        this.prizeClass = prizeClass;
    }


    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket won a prize of class " + prizeClass + " and amount £300.");
        printStream.println("Matched the numbers 7, 35, 1, 12 from pool 1.");
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
