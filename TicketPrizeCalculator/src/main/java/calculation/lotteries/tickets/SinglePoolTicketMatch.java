package calculation.lotteries.tickets;

import util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SinglePoolTicketMatch implements TicketMatch {
    private int matches;
    private final List<String> winningNumbers = new ArrayList<>();

    public SinglePoolTicketMatch() {
        this(0);
    }

    public SinglePoolTicketMatch(int matches) {
        this.matches = matches;
    }

    public void addMatch(int winningNumber) {
        winningNumbers.add(String.valueOf(winningNumber));
        matches++;
    }

    @Override
    public String toString() {
        if (winningNumbers.isEmpty())
            return "no numbers from pool 1";
        return "the numbers " + StringUtils.concat(winningNumbers, ", ") + " from pool 1";
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
