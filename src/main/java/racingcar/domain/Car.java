package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private CarPosition position;

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

    public void moveCar() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position = position.nextPosition();
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
