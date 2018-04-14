package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;
import calculation.lotteries.TicketResolution;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketMatch;
import calculation.lotteries.tickets.TicketMatcher;

import java.util.Optional;

public class SpringLottoTicketResolution implements TicketResolution {

    private final TicketMatcher ticketMatcher;
    private final PrizeStructure prizeStructure;

    public SpringLottoTicketResolution(TicketMatcher ticketMatcher, PrizeStructure prizeStructure) {
        this.prizeStructure = prizeStructure;
        this.ticketMatcher = ticketMatcher;
    }

    @Override
    public LotteryResult getResult(LotteryTicket ticket) {
        TicketMatch ticketMatch = ticketMatcher.getMatch(ticket);

        Optional<Prize> prize = prizeStructure.lookup(ticketMatch);

        Optional<LotteryResult> win = prize.map(p -> new SpringLottoWin(p, ticketMatch));
        return win.orElse(LotteryResults.unsuccessfulTicket);
    }

}