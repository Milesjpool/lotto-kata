package calculation.lotteries.springlotto;

import calculation.lotteries.Lottery;
import calculation.lotteries.tickets.validation.NumberSetValidation;
import calculation.lotteries.Prize;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.results.LotteryResults;

public class SpringLotto implements Lottery {

    private final NumberSetValidation numberSetValidation;

    public SpringLotto(NumberSetValidation numberSetValidation) {
        this.numberSetValidation = numberSetValidation;
    }

    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        if (!isValidTicket(ticket))
            return LotteryResults.malformedTicket;

        Prize prize = new Prize(3, "300");
        return new SpringLottoWin(prize);
    }

    private boolean isValidTicket(LotteryTicket ticket) {
        return numberSetValidation.isValid(ticket.getWinningNumbers())
                && numberSetValidation.isValid(ticket.getTicketNumbers());
    }


}
