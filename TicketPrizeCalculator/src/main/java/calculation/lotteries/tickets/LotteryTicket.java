package calculation.lotteries.tickets;

import java.util.Arrays;
import java.util.Objects;

public class LotteryTicket {
    private final String lotteryName;
    private int[] winningNumbers;
    private int[] ticketNumbers;

    public LotteryTicket(String lotteryName, int[] winningNumbers, int[] ticketNumbers) {
        this.lotteryName = lotteryName;
        this.winningNumbers = winningNumbers;
        this.ticketNumbers = ticketNumbers;
    }

    public String getLotteryName() {
        return lotteryName;
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int[] getTicketNumbers() {
        return ticketNumbers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryName, winningNumbers, ticketNumbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof LotteryTicket))
            return false;
        LotteryTicket o = (LotteryTicket) obj;
        return o.lotteryName == this.lotteryName
                && Arrays.equals(o.winningNumbers, this.winningNumbers)
                && Arrays.equals(o.ticketNumbers, this.ticketNumbers);
    }
}
