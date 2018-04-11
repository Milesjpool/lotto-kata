package calculation.lotteries;

import io.Printable;

import java.util.HashMap;
import java.util.Map;

public class LotteryRegistry {

    private final Map<String, Lottery> lotteries = new HashMap<>();
    private final Lottery defaultLottery;

    public LotteryRegistry(Lottery defaultLottery) {
        this.defaultLottery = defaultLottery;
    }

    public Printable getLotteryPrize(LotteryTicket lotteryTicket) {
        String lotteryName = standardise(lotteryTicket.getLotteryName());
        return lotteries.getOrDefault(lotteryName, defaultLottery)
                .evaluateTicket(lotteryTicket);
    }

    public void registerLottery(String lotteryName, Lottery lottery) {
        lotteries.put(standardise(lotteryName), lottery);
    }

    private String standardise(String lotteryName) {
        return lotteryName.toLowerCase();
    }
}
