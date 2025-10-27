package racingcar.domain.rule;

import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

public class RacingRule {

    private final NumberGenerator generator;

    public RacingRule(NumberGenerator generator) {
        this.generator = generator;
    }

    public boolean isMoveable() {
        int randomNumber = generator.generate();

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }
}

