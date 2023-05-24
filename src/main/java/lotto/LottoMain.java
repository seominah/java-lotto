package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Question;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputPrice = new InputView(Question.PRICE_QUESTION);
        OutputView outputView = new OutputView();

        int amonut = LottoGenerator.getAmount(new LottoPrice(inputPrice.getPrice()));
        outputView.lottoAmountPrint(amonut);
        Lottos lottos = LottoGenerator.generate(inputPrice.getPrice());
        lottos.getLottos().forEach(System.out::println);

        InputView inputView = new InputView(Question.WON_NUMBER_QUESTION);
        Lotto wonNumbers = inputView.getWonNumbers();
        List<Integer> hitNumber = lottos.hitNumber(lottos, wonNumbers);
        double profit = LottoDrawer.calProfit(inputPrice.getPrice(), hitNumber);

        outputView.winningPrint(hitNumber, profit);
    }
}
