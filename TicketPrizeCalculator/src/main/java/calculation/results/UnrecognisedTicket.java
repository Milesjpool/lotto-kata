package calculation.results;

import calculation.lotteries.LotteryResult;

import java.io.PrintStream;

public class UnrecognisedTicket implements LotteryResult {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("This is not a recognised ticket.");
    }
}
