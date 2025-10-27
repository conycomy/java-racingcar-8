package racingcar.util;

import racingcar.util.NumberGenerator;

/**
 * RacingRule 테스트를 위해 항상 고정된 값을 반환하는 테스트 대역(Test Double)
 */
public class TestNumberGenerator implements NumberGenerator {

    private final int fixedNumber;

    public TestNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generate() {
        return fixedNumber; // 외부에서 설정한 고정된 값만 반환
    }
}