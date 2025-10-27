package racingcar.domain.rule;

import racingcar.util.RandomNumberGenerator;

public class RacingRule {

    private final RandomNumberGenerator generator;

    public RacingRule(RandomNumberGenerator generator) {
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

