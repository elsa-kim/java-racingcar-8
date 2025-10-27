package racingcar.domain;

import java.util.List;

public class Cars {
    private static final String MINIMUM_CAR_COUNT_ERROR_MESSAGE = "자동차는 %d대 이상 입력해주세요.";

    private static final int MINIMUM_CAR_COUNT = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarsCount(cars);
        this.cars = cars;
    }

    public static Cars from(CarNames carNames) {
        List<Car> carList = carNames.getCarNames().stream()
                .map(Car::of)
                .toList();

        return new Cars(carList);
    }

    public void move() {
        cars.forEach(Car::moveCar);
    }

    public List<String> findWinner() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        int winnerPosition = maxPosition;
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    private void validateCarsCount(List<Car> cars) {
        if (cars.size() < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(String.format(MINIMUM_CAR_COUNT_ERROR_MESSAGE, MINIMUM_CAR_COUNT));
        }
    }
}
