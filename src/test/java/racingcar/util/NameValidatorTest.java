package racingcar.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameValidatorTest {

    private NameValidator nameValidator;

    @BeforeEach
    void setUp() {
        nameValidator = new NameValidator();
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외를 발생시킨다.")
    void validateNameLength_ShouldThrowException_WhenNameIsOverFiveCharacters() {
        String input = "pobi,javaji";

        assertThatThrownBy(() -> nameValidator.validateAndGetNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("이름이 중복되면 예외를 발생시킨다.")
    void validateEmptyOrDuplicate_ShouldThrowException_WhenNameIsDuplicated() {
        String input = "pobi,woni,pobi";

        assertThatThrownBy(() -> nameValidator.validateAndGetNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다");
    }



    @Test
    @DisplayName("유효한 이름 목록은 예외 없이 List<String>을 반환한다.")
    void validateAndGetNames_ShouldReturnNames_WhenInputIsValid() {
        String input = "pobi,woni,kris";

        List<String> names = nameValidator.validateAndGetNames(input);

        // 반환된 리스트의 크기와 내용이 정확한지 검증
        assertThat(names).hasSize(3)
                .containsExactly("pobi", "woni", "kris");
    }
}