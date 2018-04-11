package calculation;

import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.LotteryTicket;
import calculation.results.CalculationResults;
import io.ArgumentParser;
import io.InvalidArgumentException;
import io.Printable;

public class TicketPrizeCalculation {
    private final LotteryRegistry lotteryRegistry;
    private final ArgumentParser<LotteryTicket> ticketParser;

    public TicketPrizeCalculation(LotteryRegistry lotteryRegistry, ArgumentParser<LotteryTicket> ticketParser) {
        this.lotteryRegistry = lotteryRegistry;
        this.ticketParser = ticketParser;
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

