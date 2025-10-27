package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameValidator {

    public List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    //2. 이름 길이를 검증하는 책임
    public void validateNameLength(List<String> names) {
        boolean isOverLength = names.stream()
                .anyMatch(name -> name.length() > 5);

        if (isOverLength) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }

    }

    // 3. 이름이 비어있거나 중복되는지 검증되는 책임
    public void validateEmptyOrDuplicate(List<String> names) {
        if (names.isEmpty() || names.contains("")) {
            throw new IllegalArgumentException("이름은 쉼표 외에 공백일 수 없으며, 최소 1개 이상을 입력 해야 합니다.");
        }
        long distinctCount = names.stream()
                .distinct()
                .count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다. 다른 닉네임을 설정해주세요");
        }
    }

    public List<String> validateAndGetNames(String input) {
        List<String> names = splitByComma(input);

        names = names.stream()
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        validateNameLength(names);
        validateEmptyOrDuplicate(names);
        return names;
    }


}
