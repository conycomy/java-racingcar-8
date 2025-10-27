package racingcar.domain;

import racingcar.domain.rule.RacingRule;

public class Car implements RaceParticipant {
    private final String name;
    private Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position(0);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void move(RacingRule rule) {
        boolean isMoveable = rule.isMovable();
        this.position = this.position.advance(isMoveable);

    }
}
