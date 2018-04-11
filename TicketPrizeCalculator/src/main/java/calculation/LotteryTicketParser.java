package calculation;

import calculation.lotteries.LotteryTicket;
import com.sun.javaws.exceptions.InvalidArgumentException;
import io.ArgumentParser;

public class LotteryTicketParser implements ArgumentParser<LotteryTicket> {
    public LotteryTicket parse(String[] args) throws InvalidArgumentException {
        if (args == null || args.length != 3)
            throw new InvalidArgumentException(args);

        String lotteryName = args[0];
        return new LotteryTicket(lotteryName);
    }

}
