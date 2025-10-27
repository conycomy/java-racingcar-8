package racingcar.util;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
   public int generate() {
        final int START_RANGE = 0;
        final int END_RANGE = 9;

        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
