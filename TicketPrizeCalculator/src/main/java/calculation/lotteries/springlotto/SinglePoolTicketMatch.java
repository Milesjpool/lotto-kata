package calculation.lotteries.springlotto;

import calculation.lotteries.tickets.TicketMatch;
import util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SinglePoolTicketMatch implements TicketMatch {
    private int poolId;
    private int matches;
    private final List<String> winningNumbers = new ArrayList<>();

    public SinglePoolTicketMatch() {
        this(1, 0);
    }

    public SinglePoolTicketMatch(int matches) {
        this(1, matches);
    }

    public SinglePoolTicketMatch(int poolId, int matches) {
        this.matches = matches;
        this.poolId = poolId;
    }

    public void addMatch(int winningNumber) {
        winningNumbers.add(String.valueOf(winningNumber));
        matches++;
    }

    @Override
    public String toString() {
        if (winningNumbers.isEmpty())
            return "no numbers from pool 1";
        String plural = (winningNumbers.size() > 1) ? "s" : "";
        return "the number" + plural + " " + StringUtils.concat(winningNumbers, ", ") + " from pool " + poolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof SinglePoolTicketMatch))
            return false;
        SinglePoolTicketMatch o = (SinglePoolTicketMatch) obj;
        return o.matches == this.matches;
    }

}
