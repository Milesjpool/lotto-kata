package calculation.lotteries.tickets;

public interface TicketMatcher {
    TicketMatch getMatch(LotteryTicket entry);
}
