package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {
    @Test
    void get_lottos_twice_time() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1, 2, 3, 4, 5, 6"));
        lottoList.add(new Lotto("11, 12, 13, 14, 15, 16"));
        lottoList.add(new Lotto("21, 22, 23, 24, 25, 26"));
        lottoList.add(new Lotto("31, 32, 33, 34, 35, 36"));
        Lottos lottos = new Lottos(lottoList);
        lottos.getLottos().remove(0);
        assertEquals(lottos.getLottos().size(), 4);
    }
}
