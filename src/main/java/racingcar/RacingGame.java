package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RaceParticipant;
import racingcar.domain.RaceResult;
import racingcar.domain.RacingParticipants;
import racingcar.domain.rule.RacingRule;
import racingcar.io.InputView;
import racingcar.io.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final InputView inputView;
    private final ResultView resultView;
    private final RacingRule racingRule;

    public RacingGame(InputView inputView, ResultView resultView, RacingRule racingRule) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.racingRule = racingRule;
    }

    public void play() {
        List<String> carNames = inputView.readCarNames();
        int tryCount = inputView.readTryCount();

        RacingParticipants participants = createParticipants(carNames);

        runRounds(participants, tryCount);

        printFinalResult(participants);
    }

    private RacingParticipants createParticipants(List<String> names) {
        List<RaceParticipant> participantList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingParticipants(participantList);
    }

    private void runRounds(RacingParticipants participants, int tryCount) {
        resultView.printStartMessage();
        for (int i = 0; i < tryCount; i++) {
            participants.moveAll(racingRule);
            resultView.printRoundResult(participants.getParticipants());
        }
    }

    private void printFinalResult(RacingParticipants participants) {
        RaceResult result = participants.createResult();
        resultView.printWinners(result);
    }
}