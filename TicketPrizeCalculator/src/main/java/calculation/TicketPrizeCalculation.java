package calculation;

import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.tickets.LotteryTicket;
import calculation.results.CalculationResults;
import io.ArgumentParser;
import io.InvalidArgumentException;
import io.Printable;

public class TicketPrizeCalculation {
    private final ArgumentParser<LotteryTicket> ticketParser;
    private final LotteryRegistry lotteryRegistry;

    public TicketPrizeCalculation(ArgumentParser<LotteryTicket> ticketParser, LotteryRegistry lotteryRegistry) {
        this.ticketParser = ticketParser;
        this.lotteryRegistry = lotteryRegistry;
    }

    public Printable calculate(String[] args) {
        try {
            LotteryTicket lotteryTicket = ticketParser.parse(args);
            return lotteryRegistry.getLotteryPrize(lotteryTicket);
        }
        catch (InvalidArgumentException e){
            return CalculationResults.invalidArguments;
        }
    }

}

