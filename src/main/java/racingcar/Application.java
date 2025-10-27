package racingcar;

import racingcar.domain.rule.RacingRule;
import racingcar.util.NameValidator;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.io.InputView;
import racingcar.io.ResultView;

public class Application {

    public static void main(String[] args) {
        NameValidator nameValidator = new NameValidator();

        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RacingRule racingRule = new RacingRule(randomNumberGenerator);

        InputView inputView = new InputView(nameValidator);

        ResultView resultView = new ResultView();

        RacingGame game = new RacingGame(inputView, resultView, racingRule);

        game.play();
    }
}