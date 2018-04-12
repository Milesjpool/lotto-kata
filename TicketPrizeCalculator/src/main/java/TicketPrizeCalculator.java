import calculation.LotteryNumberParser;
import calculation.LotteryTicketParser;
import calculation.TicketPrizeCalculation;
import calculation.lotteries.NullLottery;
import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.tickets.validation.ChainedNumberSetValidation;
import calculation.lotteries.springlotto.SpringLotto;
import calculation.lotteries.tickets.validation.NoDuplicateNumbersValidation;
import calculation.lotteries.tickets.validation.NumberRangeValidation;
import calculation.lotteries.tickets.validation.NumberSetLengthValidation;
import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();

    private static final LotteryTicketParser argumentParser = new LotteryTicketParser(new LotteryNumberParser());
    private static final LotteryRegistry lotteryRegistry;

    private static final SpringLotto springLotto = new SpringLotto(
            new ChainedNumberSetValidation(
                    new NumberSetLengthValidation(6),
                    new NumberRangeValidation(1, 36),
                    new NoDuplicateNumbersValidation()
            ));

    static {
        lotteryRegistry = new LotteryRegistry(new NullLottery());
        lotteryRegistry.registerLottery("SpringLotto", springLotto);
    }

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        final TicketPrizeCalculation ticketPrizeCalculation = new TicketPrizeCalculation(argumentParser, lotteryRegistry);
        Printable calculationResult = ticketPrizeCalculation.calculate(args);

        calculationResult.print(System.out);
    }

}
