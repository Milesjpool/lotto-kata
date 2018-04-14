package calculation.lotteries.tickets;

import java.util.Objects;

public class SinglePoolTicketMatch implements TicketMatch {
    private int matches;

    public SinglePoolTicketMatch() {
        this(0);
    }

    public SinglePoolTicketMatch(int matches) {
        this.matches = matches;
    }

    public void addMatch() {
        matches++;
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
