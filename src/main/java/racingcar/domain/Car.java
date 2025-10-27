package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private CarPosition position = CarPosition.generate();

    private Car(CarName name) {
        this.name = name;
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void moveCar() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position = position.nextPosition();
        }
    }
}
