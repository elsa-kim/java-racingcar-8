package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printCarNameRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountRequestMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRoundStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRound(List<Map<String, Integer>> carsStatus) {
        carsStatus.stream()
                .flatMap(map -> map.entrySet().stream())
                .forEach(entry -> System.out.println(
                        entry.getKey() + " : " + "-".repeat(entry.getValue())
                ));
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
