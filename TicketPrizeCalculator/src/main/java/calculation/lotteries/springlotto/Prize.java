package calculation.lotteries.springlotto;

import java.util.Objects;

public class Prize {
    private final int prizeClass;
    private final String winnings;

    Prize(int prizeClass, String winnings) {
        this.prizeClass = prizeClass;
        this.winnings = winnings;
    }

    @Override
    public String toString() {
        return "a prize of class " + prizeClass + " and amount £" + winnings + ".";
    }


    @Override
    public int hashCode() {
        return Objects.hash(prizeClass, winnings);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Prize))
            return false;
        Prize o = (Prize) obj;
        return o.prizeClass == this.prizeClass
                && o.winnings == this.winnings;
    }
}
