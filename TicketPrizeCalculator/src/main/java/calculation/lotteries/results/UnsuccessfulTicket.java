package calculation.lotteries.results;

import java.io.PrintStream;

public class UnsuccessfulTicket implements LotteryResult {

    @Override
    public void print(PrintStream printStream) {
        printStream.println("This ticket did not win a prize.");
    }
}
