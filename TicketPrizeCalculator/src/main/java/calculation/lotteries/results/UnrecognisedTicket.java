package calculation.lotteries.results;

import java.io.PrintStream;

public class UnrecognisedTicket implements LotteryResult {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("This is not a recognised ticket.");
    }
}
