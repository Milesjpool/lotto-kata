package calculation.lotteries.prizes;

import calculation.lotteries.tickets.TicketMatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrizeStructure {
    private Map<TicketMatch, Prize> prizes = new HashMap<>();

    public Optional<Prize> lookup(TicketMatch ticketMatch) {
        return Optional.ofNullable(prizes.get(ticketMatch));
    }

    public void addPrize(TicketMatch match, Prize prize) {
        prizes.put(match, prize);
    }
}