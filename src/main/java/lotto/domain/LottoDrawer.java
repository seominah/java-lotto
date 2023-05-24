package lotto.domain;

import lotto.view.Prize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoDrawer {
    private LottoDrawer() {
    }

    public static double calProfit(Money price, List<Integer> hitNumbers) {
        return price
                .profit(totalPrize(hitNumbers))
                .doubleValue();
    }

    public static BigDecimal totalPrize(List<Integer> hitNumbers) {
        BigDecimal totalPrize = BigDecimal.ZERO;

        for (Integer i : hitNumbers) {
            totalPrize = totalPrize.add(BigDecimal.valueOf(Prize.calculatePrize(i)));
        }
        return totalPrize;
    }
}
