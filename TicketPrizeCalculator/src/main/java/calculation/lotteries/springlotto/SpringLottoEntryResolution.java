package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketMatch;
import calculation.lotteries.tickets.TicketMatcher;

import java.util.Optional;

public class SpringLottoEntryResolution {

    private final PrizeStructure prizeStructure;
    private final TicketMatcher ticketMatcher;

    public SpringLottoEntryResolution(PrizeStructure prizeStructure, TicketMatcher ticketMatcher) {
        this.prizeStructure = prizeStructure;
        this.ticketMatcher = ticketMatcher;
    }

    LotteryResult getResult(LotteryTicket ticket) {
        TicketMatch ticketMatch = ticketMatcher.getMatch(ticket);

        Optional<Prize> prize = prizeStructure.lookup(ticketMatch);

        Optional<LotteryResult> win = prize.map(p -> new SpringLottoWin(p, ticketMatch));
        return win.orElse(LotteryResults.unsuccessfulTicket);
    }

}