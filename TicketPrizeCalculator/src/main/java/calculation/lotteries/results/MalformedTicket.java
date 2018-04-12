package calculation.lotteries.results;

import java.io.PrintStream;

public class MalformedTicket implements LotteryResult {
    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket is malformed.");
    }
}
