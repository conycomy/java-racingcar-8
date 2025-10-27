package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.util.NameValidator; // NameValidator 클래스 임포트

public class InputView {

    private final NameValidator nameValidator;

    public InputView(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    public List<String> readCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

            try {
                String input = Console.readLine();

                return nameValidator.validateAndGetNames(input);

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int readTryCount() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");

            try {
                String input = Console.readLine();

                int count = Integer.parseInt(input);

                if (count <= 0) {
                    throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
                }

                return count; // 성공 시 반환

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자 형식이어야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}