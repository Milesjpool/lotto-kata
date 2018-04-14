package calculation.lotteries.springlotto;

import calculation.lotteries.LotteryEntry;
import calculation.lotteries.Prize;
import calculation.lotteries.tickets.SinglePoolTicketMatch;

import java.util.Optional;

public class SpringLottoEntryResolution {

    private final PrizeStructure prizeStructure;

    public SpringLottoEntryResolution(PrizeStructure prizeStructure) {
        this.prizeStructure = prizeStructure;
    }

    Optional<Prize> resolve(LotteryEntry entry) {
        int[] winningNumbers = entry.getWinningNumbers();
        int[] ticketNumbers = entry.getTicketNumbers();

        SinglePoolTicketMatch ticketMatch = new SinglePoolTicketMatch();
        for (int i = 0; i < winningNumbers.length; i++) {
            if (winningNumbers[i] == ticketNumbers[i]) {
                ticketMatch.addMatch();
            }
        }

        return Optional.ofNullable(prizeStructure.lookup(ticketMatch));
    }

}