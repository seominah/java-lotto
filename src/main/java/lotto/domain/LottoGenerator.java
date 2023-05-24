package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lottos generate(Money price) {
        int amount = getAmount(new LottoPrice(price));
        return new Lottos(amount);
    }

    public static int getAmount(LottoPrice lottoPrice) {
        return lottoPrice.getAmount();
    }
}
