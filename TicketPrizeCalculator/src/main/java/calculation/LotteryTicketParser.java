package calculation;

import calculation.lotteries.LotteryTicket;
import io.ArgumentParser;
import io.InvalidArgumentException;

public class LotteryTicketParser implements ArgumentParser<LotteryTicket> {
    public LotteryTicket parse(String[] args) throws InvalidArgumentException {
        if (args == null || args.length != 3)
            throw new InvalidArgumentException();

        String lotteryName = args[0];
        return new LotteryTicket(lotteryName);
    }

}
