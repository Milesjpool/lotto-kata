package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.tickets.TicketMatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrizeStructure {
    private Map<TicketMatch, Prize> prizes = new HashMap<>();

    Optional<Prize> lookup(TicketMatch ticketMatch) {
        return Optional.ofNullable(prizes.get(ticketMatch));
    }

    public void addPrize(TicketMatch match, Prize prize) {
        prizes.put(match, prize);
    }
}