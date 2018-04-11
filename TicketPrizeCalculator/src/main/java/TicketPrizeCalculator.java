import calculation.LotteryTicketParser;
import calculation.TicketPrizeCalculation;
import calculation.lotteries.NullLottery;
import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.springlotto.SpringLotto;
import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();
    private static final LotteryRegistry lotteryRegistry;
    private static final LotteryTicketParser argumentParser = new LotteryTicketParser();

    static {
        lotteryRegistry = new LotteryRegistry(new NullLottery());
        lotteryRegistry.registerLottery("SpringLotto", new SpringLotto());
    }

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        final TicketPrizeCalculation ticketPrizeCalculation = new TicketPrizeCalculation(lotteryRegistry, argumentParser);
        Printable calculationResult = ticketPrizeCalculation.calculate(args);

        calculationResult.print(System.out);
    }

}
