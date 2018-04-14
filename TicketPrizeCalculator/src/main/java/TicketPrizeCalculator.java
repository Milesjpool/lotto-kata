import calculation.LotteryNumberParser;
import calculation.LotteryTicketParser;
import calculation.TicketPrizeCalculation;
import calculation.lotteries.LotteryRegistry;
import calculation.lotteries.NullLottery;
import calculation.lotteries.Prize;
import calculation.lotteries.springlotto.PrizeStructure;
import calculation.lotteries.springlotto.SpringLotto;
import calculation.lotteries.springlotto.SpringLottoEntryResolution;
import calculation.lotteries.springlotto.SpringLottoTicketMatcher;
import calculation.lotteries.tickets.SinglePoolTicketMatch;
import calculation.lotteries.tickets.validation.ChainedNumberSetValidation;
import calculation.lotteries.tickets.validation.NoDuplicateNumbersValidation;
import calculation.lotteries.tickets.validation.NumberRangeValidation;
import calculation.lotteries.tickets.validation.NumberSetLengthValidation;
import io.Printable;
import io.metadata.ApplicationHeader;

public class TicketPrizeCalculator {

    private static final Printable APPLICATION_HEADER = new ApplicationHeader();

    private static final LotteryTicketParser argumentParser = new LotteryTicketParser(new LotteryNumberParser());
    private static final LotteryRegistry lotteryRegistry = new LotteryRegistry(new NullLottery());
    private static final PrizeStructure springLottoPrizeStructure = new PrizeStructure();

    private static final SpringLotto springLotto = new SpringLotto(
            new ChainedNumberSetValidation(
                    new NumberSetLengthValidation(6),
                    new NumberRangeValidation(1, 36),
                    new NoDuplicateNumbersValidation()
            ), new SpringLottoEntryResolution(springLottoPrizeStructure, new SpringLottoTicketMatcher()));

    static {
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(6), new Prize(1, "500,000"));
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(5), new Prize(2, "2,000"));
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(4), new Prize(3, "300"));
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(3), new Prize(4, "50"));
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(2), new Prize(5, "12"));
        springLottoPrizeStructure.addPrize(new SinglePoolTicketMatch(1), new Prize(6, "3"));
        lotteryRegistry.registerLottery("SpringLotto", springLotto);
    }

    public static void main(String[] args){
        APPLICATION_HEADER.print(System.out);

        final TicketPrizeCalculation ticketPrizeCalculation = new TicketPrizeCalculation(argumentParser, lotteryRegistry);
        Printable calculationResult = ticketPrizeCalculation.calculate(args);

        calculationResult.print(System.out);
    }

}
