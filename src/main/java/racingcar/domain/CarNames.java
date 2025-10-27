package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름은 중복일 수 없습니다.";

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        validateUniqueCarNames(carNames);
        this.carNames = carNames;
    }

    public static CarNames from(String input) {
        String[] splitCarNames = input.split(CAR_NAME_DELIMITER, -1);
        List<CarName> carNameList = Arrays.stream(splitCarNames)
                .map(CarName::of)
                .toList();

        return new CarNames(carNameList);
    }

    public List<CarName> getCarNames() {
        return List.copyOf(carNames);
    }

    private void validateUniqueCarNames(List<CarName> carNames) {
        if (isDuplicated(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicated(List<CarName> carNames) {
        return carNames.size() != carNames.stream()
                .map(CarName::getName)
                .distinct()
                .count();
    }
}
