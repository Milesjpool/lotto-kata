package calculation.lotteries.tickets;

import calculation.lotteries.prizes.Prize;
import calculation.lotteries.prizes.PrizeStructure;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.results.LotteryWin;

import java.util.Optional;

public class TicketResolution {

    private final TicketMatcher ticketMatcher;
    private final PrizeStructure prizeStructure;

    public TicketResolution(TicketMatcher ticketMatcher, PrizeStructure prizeStructure) {
        this.prizeStructure = prizeStructure;
        this.ticketMatcher = ticketMatcher;
    }

    public LotteryResult getResult(LotteryTicket ticket) {
        TicketMatch ticketMatch = ticketMatcher.getMatch(ticket);

        Optional<Prize> prize = prizeStructure.lookup(ticketMatch);

        Optional<LotteryResult> win = prize.map(p -> new LotteryWin(p, ticketMatch));
        return win.orElse(LotteryResults.unsuccessfulTicket);
    }

}