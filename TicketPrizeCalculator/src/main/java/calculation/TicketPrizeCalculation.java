package calculation;

import calculation.lotteries.LotteryRegistry;
import calculation.results.CalculationResults;
import com.sun.javaws.exceptions.InvalidArgumentException;
import io.Printable;

public class TicketPrizeCalculation {
    private final LotteryRegistry lotteryRegistry;
    private String[] args;

    public TicketPrizeCalculation(String[] args, LotteryRegistry lotteryRegistry) {
        this.args = args;
        this.lotteryRegistry = lotteryRegistry;
    }

    public Printable execute() {
        try {
            if (args == null || args.length != 3)
                throw new InvalidArgumentException(args);

            String lotteryName = args[0];
            return lotteryRegistry.getLotteryPrize(lotteryName);
        }
        catch (InvalidArgumentException e){
            return CalculationResults.invalidArguments;
        }
    }

}

