package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("generate()는 0~9 사이의 정수를 반환한다.")
    void generate_returnNumbersWithinRange() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        for (int i = 0; i < 100; i++) {
            int number = generator.generate();
            assertThat(number)
                    .as("반환 값은 0 이상 9 이하여야 한다.")
                    .isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("generate()는 호출할 때마다, 값이 달라질 가능성이 존재한다.")
    void generate_returnsRandomValues() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            results.add(generator.generate());
        }

        assertThat(results.size())
                .as("랜덤 값이 달라지는지 확인 ")
                .isGreaterThan(1);
    }

    @Test
    @DisplayName("generate() 호출 시 예외  없이 정상 작동한다")
    void generate_runsWithoutException() {
        RandomNumberGenerator generator = new RandomNumberGenerator();

        assertThatCode(generator::generate)
                .doesNotThrowAnyException();
    }


}
