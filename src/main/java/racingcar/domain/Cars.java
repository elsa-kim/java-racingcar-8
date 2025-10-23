package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateUniqueCarNames(cars);
        this.cars = cars;
    }

    public static Cars of(String input) {
        List<Car> cars = Arrays.stream(input.split(",", -1)).map(Car::of).toList();
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    private void validateUniqueCarNames(List<Car> cars) {
        if (cars.stream().map(Car::getName).distinct().count() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }


    public List<Map<String, Integer>> getCarsStatus() {
        return cars.stream().map(Car::getStatus).toList();
    }
}
