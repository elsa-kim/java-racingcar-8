package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    private final CarName name;
    private int position = 0;

    private Car(CarName name) {
        this.name = name;
    }

    public static Car of(String input) {
        CarName name = CarName.of(input);
        return new Car(name);
    }

    public CarName getName() {
        return name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public Map<String, Integer> getStatus() {
        return Map.of(name.getName(), position);
    }

    public int maxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }
}
