package calculation.lotteries.javamillions;

import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketMatch;
import calculation.lotteries.tickets.TicketMatcher;

public class JavaMillionsTicketMatcher implements TicketMatcher {
    private static final int POOL_1_SIZE = 5;
    private static final int POOL_2_SIZE = 1;
    @Override
    public TicketMatch getMatch(LotteryTicket entry) {
        TwoPoolTicketMatch ticketMatch = new TwoPoolTicketMatch();
        int[] ticketNumbers = entry.getTicketNumbers();
        int[] winningNumbers = entry.getWinningNumbers();

        for (int i = 0; i < POOL_1_SIZE; i++) {
            for (int j = 0; j < POOL_1_SIZE; j++) {
                if (winningNumbers[i] == ticketNumbers[j])
                    ticketMatch.addMatch(1, winningNumbers[i]);
            }
        }

        for (int i = POOL_1_SIZE; i < POOL_1_SIZE+POOL_2_SIZE; i++) {
            for (int j = POOL_1_SIZE; j < POOL_1_SIZE+POOL_2_SIZE; j++) {
                if (winningNumbers[i] == ticketNumbers[j])
                    ticketMatch.addMatch(2, winningNumbers[i]);
            }
        }

        return ticketMatch;
    }
}
