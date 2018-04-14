package calculation.lotteries.javamillions;

import calculation.lotteries.springlotto.SinglePoolTicketMatch;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketMatch;
import calculation.lotteries.tickets.TicketMatcher;

public class JavaMillionsTicketMatcher implements TicketMatcher {
    private static final int POOL_1_SIZE = 5;
    private static final int POOL_2_SIZE = 1;
    @Override
    public TicketMatch getMatch(LotteryTicket entry) {
        int[] ticketNumbers = entry.getTicketNumbers();
        int[] winningNumbers = entry.getWinningNumbers();

        SinglePoolTicketMatch pool1matches = getMatches(1, winningNumbers, ticketNumbers, 0, POOL_1_SIZE);
        SinglePoolTicketMatch pool2matches = getMatches(2, winningNumbers, ticketNumbers, POOL_1_SIZE, POOL_2_SIZE);
        return new TwoPoolTicketMatch(pool1matches, pool2matches);
    }

    private SinglePoolTicketMatch getMatches(int poolId, int[] winningNumbers, int[] ticketNumbers, int start, int count) {
        SinglePoolTicketMatch ticketMatch = new SinglePoolTicketMatch(poolId, 0);

        for (int i = start; i < start+count; i++) {
            for (int j = start; j < start+count; j++) {
                if (winningNumbers[i] == ticketNumbers[j])
                    ticketMatch.addMatch(winningNumbers[i]);
            }
        }
        return ticketMatch;
    }
}
