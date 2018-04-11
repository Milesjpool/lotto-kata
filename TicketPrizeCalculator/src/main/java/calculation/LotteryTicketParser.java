package calculation;

import calculation.lotteries.LotteryTicket;
import io.ArgumentParser;
import io.InvalidArgumentException;

public class LotteryTicketParser implements ArgumentParser<LotteryTicket> {
    private final LotteryNumberParser lotteryNumberParser;

    public LotteryTicketParser(LotteryNumberParser lotteryNumberParser) {
        this.lotteryNumberParser = lotteryNumberParser;
    }

    public LotteryTicket parse(String[] args) throws InvalidArgumentException {
        if (args == null || args.length != 3)
            throw new InvalidArgumentException();

        String lotteryName = args[0];

        int[] winningNumbers = getNumbers(args[1]);
        int[] ticketNumbers = getNumbers(args[2]);
        return new LotteryTicket(lotteryName, winningNumbers, ticketNumbers);

    }

    private int[] getNumbers(String arg) throws InvalidArgumentException {
        try {
            return lotteryNumberParser.getNumbers(arg);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException();
        }
    }
}
