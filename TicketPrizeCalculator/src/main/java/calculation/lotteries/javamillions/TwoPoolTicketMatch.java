package calculation.lotteries.javamillions;

import calculation.lotteries.springlotto.SinglePoolTicketMatch;
import calculation.lotteries.tickets.TicketMatch;

import java.util.Objects;

public class TwoPoolTicketMatch implements TicketMatch {
    private SinglePoolTicketMatch[] poolMatches = new SinglePoolTicketMatch[2];

    public TwoPoolTicketMatch(int pool1Matches, int pool2Matches) {
        this(new SinglePoolTicketMatch(1, pool1Matches), new SinglePoolTicketMatch(2, pool2Matches));
    }

    TwoPoolTicketMatch(SinglePoolTicketMatch pool1matches, SinglePoolTicketMatch pool2matches) {
        this.poolMatches[0] = pool1matches;
        this.poolMatches[1] = pool2matches;
    }

    @Override
    public String toString() {
        return poolMatches[0].toString() + " and " + poolMatches[1].toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(poolMatches[0], poolMatches[1]);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof TwoPoolTicketMatch))
            return false;
        TwoPoolTicketMatch o = (TwoPoolTicketMatch) obj;
        return o.poolMatches[0].equals(this.poolMatches[0])
                && o.poolMatches[1].equals(this.poolMatches[1]);
    }
}
