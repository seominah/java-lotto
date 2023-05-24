package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Money price;
    private Lotto wonNumbers;
    private int manualLottoCount;
    private Lottos manualLottos;

    public InputView(Question question) {
        Scanner scanner = new Scanner(System.in);
        if (question.equals(Question.PRICE_QUESTION)) {
            System.out.println(Question.PRICE_QUESTION.getQuestionValue());
            price = new Money(scanner.nextInt());
        }
        if (question.equals(Question.WON_NUMBER_QUESTION)) {
            System.out.println(Question.WON_NUMBER_QUESTION.getQuestionValue());
            wonNumbers = new Lotto(scanner.nextLine());
        }
        if (question.equals(Question.MANUAL_LOTTO_COUNT)) {
            System.out.println(Question.MANUAL_LOTTO_COUNT.getQuestionValue());
            manualLottoCount = scanner.nextInt();
        }
        if (question.equals(Question.MANUAL_LOTTOS_NUMBERS)) {
            System.out.println(Question.MANUAL_LOTTOS_NUMBERS.getQuestionValue());
            List<Lotto> lottos = new ArrayList<>();
            while (scanner.hasNext()) {
                lottos.add(new Lotto(scanner.next()));
            }
            manualLottos = new Lottos(lottos);
        }
    }

    public InputView(int price) {
        this.price = new Money(price);
    }

    public InputView(String wonNumbers) {
        this.wonNumbers = new Lotto(wonNumbers);
    }

    public Money getPrice() {
        return price;
    }

    public Lotto getWonNumbers() {
        return wonNumbers;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public Lottos getManualLottos() {
        return manualLottos;
    }
}
