package calculation.lotteries;

import java.util.Objects;

public class LotteryTicket {
    private final String lotteryName;

    public LotteryTicket(String lotteryName) {
        this.lotteryName = lotteryName;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lotteryName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof LotteryTicket))
            return false;
        LotteryTicket o = (LotteryTicket) obj;
        return o.lotteryName == this.lotteryName;
    }
}
