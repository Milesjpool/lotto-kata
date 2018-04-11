package calculation;

import calculation.lotteries.LotteryRegistry;
import calculation.results.CalculationResults;
import com.sun.javaws.exceptions.InvalidArgumentException;
import io.Printable;

public class TicketPrizeCalculation {
    private final LotteryRegistry lotteryRegistry;
    private final ArgumentParser argumentParser;
    private String[] args;

    public TicketPrizeCalculation(String[] args, LotteryRegistry lotteryRegistry, ArgumentParser argumentParser) {
        this.args = args;
        this.lotteryRegistry = lotteryRegistry;
        this.argumentParser = argumentParser;
    }

    public Printable execute() {
        try {
            String lotteryName = argumentParser.getLotteryName(args);
            return lotteryRegistry.getLotteryPrize(lotteryName);
        }
        catch (InvalidArgumentException e){
            return CalculationResults.invalidArguments;
        }
    }

}

