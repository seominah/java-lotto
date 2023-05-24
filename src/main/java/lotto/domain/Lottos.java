package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int amount) {
        for (int i = 0; i < amount; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Integer> hitNumber(Lottos lottos, Lotto wonNumber) {
        List<Integer> matchCount = new ArrayList<>();
        lottos.getLottos().forEach(
                lotto -> matchCount.add(lotto.matchedNumber(wonNumber))
        );
        return matchCount;
    }
}
