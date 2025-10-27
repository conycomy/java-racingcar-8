package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private final int maxDistance;
    private final List<RaceParticipant> winners;


    public RaceResult(List<RaceParticipant> participants) {
        this.maxDistance = caculateMaxDistance(participants);
        this.winners = findWinners(participants, this.maxDistance);
    }

    private List<RaceParticipant> findWinners(List<RaceParticipant> participants, int maxDistance) {
        return participants.stream()
                .filter(p -> p.getPosition().getPosition() == maxDistance)
                .collect(Collectors.toList());

    }

    private int caculateMaxDistance(List<RaceParticipant> participants) {
        return participants.stream()
                .mapToInt(p -> p.getPosition().getPosition())
                .max()
                .orElse(0);
    }
}

