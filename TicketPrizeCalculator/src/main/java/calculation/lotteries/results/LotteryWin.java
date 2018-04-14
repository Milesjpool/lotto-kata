package calculation.lotteries.results;

import calculation.lotteries.prizes.Prize;
import calculation.lotteries.tickets.TicketMatch;

import java.io.PrintStream;
import java.util.Objects;

public class LotteryWin implements LotteryResult {
    private final Prize prize;
    private final TicketMatch ticketMatch;

    public LotteryWin(Prize prize, TicketMatch ticketMatch) {
        this.prize = prize;
        this.ticketMatch = ticketMatch;
    }

    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket won " + prize + ".");
        printStream.println("Matched " + ticketMatch + ".");
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize, ticketMatch);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
                return false;
        if (!(obj instanceof LotteryWin))
                return false;
        LotteryWin o = (LotteryWin) obj;
        return o.prize.equals(this.prize)
                && o.ticketMatch.equals(this.ticketMatch);
    }
}
