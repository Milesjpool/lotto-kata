package calculation.lotteries;

import calculation.lotteries.results.LotteryResult;
import calculation.lotteries.results.LotteryResults;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.lotteries.tickets.TicketResolution;
import calculation.lotteries.tickets.validation.NumberSetValidation;

public class StandardLottery implements Lottery {

    private final NumberSetValidation numberSetValidation;
    private final TicketResolution ticketResolution;

    public StandardLottery(NumberSetValidation poolValidation, TicketResolution ticketResolution) {
        this.numberSetValidation = poolValidation;
        this.ticketResolution = ticketResolution;
    }

    public LotteryResult evaluateTicket(LotteryTicket ticket) {
        if (!isValidTicket(ticket))
            return LotteryResults.malformedTicket;

        return ticketResolution.getResult(ticket);
    }

    //TODO: consider separating malformed ticket and malformed draw.
    private boolean isValidTicket(LotteryTicket ticket) {
        return numberSetValidation.isValid(ticket.getWinningNumbers())
                && numberSetValidation.isValid(ticket.getTicketNumbers());
    }


}
