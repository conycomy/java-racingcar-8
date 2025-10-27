package racingcar.io;

import racingcar.domain.RaceParticipant;
import racingcar.domain.RaceResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<RaceParticipant> participants) {
        for (RaceParticipant participant : participants) {
            System.out.print(participant.getName() + " : ");

            int distance = participant.getPosition().getPosition();
            printDash(distance);
            System.out.println();
        }
        System.out.println();
    }


    public void printWinners(RaceResult result) {
        List<RaceParticipant> winners = result.getWinners();

        String winnerNames = winners.stream()
                .map(RaceParticipant::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    private void printDash(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}