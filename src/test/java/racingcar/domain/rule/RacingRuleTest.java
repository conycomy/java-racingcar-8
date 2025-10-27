package racingcar.domain.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGenerator;
import racingcar.util.TestNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRuleTest {
    @Test
    @DisplayName("4 이상일 때 true를 반환하며 전진하는지 확인")
    void isMovable_ShouldReturnTrue_WhenRandomNumberIsFourOrMore() {
        NumberGenerator testGenerator = new TestNumberGenerator(4);
        RacingRule racingRule = new RacingRule(testGenerator);

        assertThat(racingRule.isMovable()).isTrue();
    }

    @Test
    @DisplayName("3 이하일 때 false를 반환하며 정지하는지 확인")
    void isMovable_ShouldReturnFalse_WhenRandomNumberIsThreeOrLess() {
        NumberGenerator testGenerator = new TestNumberGenerator(3);
        RacingRule racingRule = new RacingRule(testGenerator);

        assertThat(racingRule.isMovable()).isFalse();
    }

    @Test
    @DisplayName("최대값 9일 때 true를 반환하며 전진하는지 확인")
    void isMovable_ShouldReturnTrue_WhenRandomNumberIsNine() {
        NumberGenerator testGenerator = new TestNumberGenerator(9);
        RacingRule racingRule = new RacingRule(testGenerator);

        assertThat(racingRule.isMovable()).isTrue();
    }
}