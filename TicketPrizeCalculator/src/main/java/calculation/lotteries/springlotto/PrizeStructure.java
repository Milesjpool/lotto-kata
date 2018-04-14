package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.tickets.TicketMatch;

import java.util.HashMap;
import java.util.Map;

public class PrizeStructure {
    private Map<TicketMatch, Prize> prizes = new HashMap<>();

    Prize lookup(TicketMatch ticketMatch) {
        return prizes.get(ticketMatch);
    }

    public void addPrize(TicketMatch match, Prize prize) {
        prizes.put(match, prize);
    }
}