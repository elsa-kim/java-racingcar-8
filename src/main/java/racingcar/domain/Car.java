package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    private final CarName name;
    private final CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String input) {
        CarName name = CarName.of(input);
        CarPosition position = CarPosition.generate();
        return new Car(name, position);
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position.go();
        }
    }

    public Map<String, Integer> getStatus() {
        return Map.of(name.getName(), position.getPosition());
    }

    public int maxPosition(int maxPosition) {
        return Math.max(position.getPosition(), maxPosition);
    }

    public boolean isWinner(int winnerPosition) {
        return position.getPosition() == winnerPosition;
    }
}
