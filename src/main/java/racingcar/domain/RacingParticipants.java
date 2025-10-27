package racingcar.domain;

import java.util.List;
import racingcar.domain.rule.RacingRule;

public class RacingParticipants {

    private final List<RaceParticipant> participants;

    public RacingParticipants(List<RaceParticipant> participants) {
        this.participants = participants;
    }

    public void moveAll(RacingRule rule) {
        this.participants.forEach(participant -> participant.move(rule));
    }

    public RaceResult createResult() {
        return new RaceResult(participants);
    }
}
