package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. 구매금액이 5000원이고 총 상금이 5000원이면 수익률은 1이다.
 */
public class LottoDrawerTest {
    @Test
    void 수익률_테스트() {
        Money 구매금액 = new Money(5000);
        Lottos 구매한_로또들 = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6")));
        Lotto 지난주_당첨번호 = new Lotto("1, 2, 3, 7, 8, 9");

        List<Integer> 일치한_당첨번호_개수 = 구매한_로또들.hitNumber(구매한_로또들, 지난주_당첨번호);

        double 수익률 = LottoDrawer.calProfit(구매금액, 일치한_당첨번호_개수);
        assertEquals(수익률, 1.0);
    }

    @Test
    void 특정_수익률_테스트() {
        Money 구매금액 = new Money(14000);
        Lottos 구매한_로또들 = new Lottos(Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6")));
        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        List<Integer> 일치한_당첨번호_개수 = 구매한_로또들.hitNumber(구매한_로또들, 지난주_당첨번호);
        double 수익률 = LottoDrawer.calProfit(구매금액, 일치한_당첨번호_개수);
        assertEquals(수익률, 0.35);
    }

    @Test
    void 일치한_당첨번호_개수_테스트() {
        Lottos 구매한_로또들 = new Lottos(
                Arrays.asList(
                        new Lotto("1, 2, 3, 4, 5, 6"),
                        new Lotto("1, 2, 3, 9, 10, 11"),
                        new Lotto("9, 10, 11, 12, 13, 14")
        ));

        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> 일치한_당첨번호_개수 = 구매한_로또들.hitNumber(구매한_로또들, 지난주_당첨번호);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 6), 1);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 3), 1);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 0), 1);
    }

    @Test
    void 중복된_일치한_당첨번호_개수_테스트() {
        Lottos 구매한_로또들 = new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 6")
        ));

        Lotto 지난주_당첨번호 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> 일치한_당첨번호_개수 = 구매한_로또들.hitNumber(구매한_로또들, 지난주_당첨번호);
        assertEquals(Collections.frequency(일치한_당첨번호_개수, 6), 2);

    }

}
