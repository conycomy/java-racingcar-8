package racingcar.domain;

import racingcar.domain.rule.RacingRule;

public interface RaceParticipant {

    String getName();

    Position getPosition();

    void move(RacingRule rule);


}
