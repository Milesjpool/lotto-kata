import calculation.LotteryTicketParser;
import calculation.TicketPrizeCalculation;
import calculation.lotteries.LotteryRegistry;
import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();
    private static final LotteryRegistry lotteryRegistry = new LotteryRegistry();
    private static final LotteryTicketParser argumentParser = new LotteryTicketParser();

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        final TicketPrizeCalculation ticketPrizeCalculation = new TicketPrizeCalculation(lotteryRegistry, argumentParser);
        Printable calculationResult = ticketPrizeCalculation.calculate(args);

        calculationResult.print(System.out);
    }

}
