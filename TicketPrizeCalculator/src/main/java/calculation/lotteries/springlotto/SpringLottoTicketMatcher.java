package calculation.lotteries.springlotto;

import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.SinglePoolTicketMatch;
import calculation.lotteries.tickets.TicketMatch;
import calculation.lotteries.tickets.TicketMatcher;

public class SpringLottoTicketMatcher implements TicketMatcher {
    @Override
    public TicketMatch getMatch(LotteryTicket entry) {
        int[] winningNumbers = entry.getWinningNumbers();
        int[] ticketNumbers = entry.getTicketNumbers();

        SinglePoolTicketMatch ticketMatch = new SinglePoolTicketMatch();
        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] == ticketNumbers[i]) {
                ticketMatch.addMatch(winningNumbers[i]);
            }
        }
        return ticketMatch;
    }
}
