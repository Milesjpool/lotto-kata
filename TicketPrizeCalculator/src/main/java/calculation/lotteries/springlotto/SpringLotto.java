package calculation.lotteries.springlotto;

import calculation.lotteries.Lottery;
import calculation.lotteries.tickets.validation.NumberSetValidation;
import calculation.lotteries.Prize;
import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.results.LotteryResults;

import java.util.Optional;

public class SpringLotto implements Lottery {

    private final NumberSetValidation numberSetValidation;
    private final SpringLottoPrizeResolution springLottoPrizeResolution;

    public SpringLotto(NumberSetValidation poolValidation, SpringLottoPrizeResolution springLottoPrizeResolution) {
        this.numberSetValidation = poolValidation;
        this.springLottoPrizeResolution = springLottoPrizeResolution;
    }

    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        if (!isValidTicket(ticket))
            return LotteryResults.malformedTicket;

        Optional<Prize> prize = springLottoPrizeResolution.resolve(ticket.getWinningNumbers(), ticket.getTicketNumbers());

        Optional<LotteryResult> winResult = prize.map(SpringLottoWin::new);
        return winResult.orElse(LotteryResults.unsuccessfulTicket);
    }

    //TODO: consider separating malformed ticket and malformed draw.
    private boolean isValidTicket(LotteryTicket ticket) {
        return numberSetValidation.isValid(ticket.getWinningNumbers())
                && numberSetValidation.isValid(ticket.getTicketNumbers());
    }


}
