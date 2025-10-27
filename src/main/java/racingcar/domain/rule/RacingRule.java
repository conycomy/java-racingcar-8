package racingcar.domain.rule;

import racingcar.util.NumberGenerator;

public class RacingRule {

    private final NumberGenerator generator;

    public RacingRule(NumberGenerator generator) {
        this.generator = generator;
    }

    public boolean isMovable() {
        int randomNumber = generator.generate();

        if (randomNumber >= 4) {
            return true;
        }

        return false;
    }
}

