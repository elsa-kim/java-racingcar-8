package racingcar.domain;

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
}
