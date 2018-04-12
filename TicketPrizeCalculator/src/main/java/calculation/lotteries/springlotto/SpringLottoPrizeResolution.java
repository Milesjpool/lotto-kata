package calculation.lotteries.springlotto;

import calculation.lotteries.Prize;

import java.util.Optional;

public class SpringLottoPrizeResolution {
    Optional<Prize> resolve(int[] winningNumbers, int[] ticketNumbers) {
        return Optional.of(new Prize(3, "300"));
    }
}