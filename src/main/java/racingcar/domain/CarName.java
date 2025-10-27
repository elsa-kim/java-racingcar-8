package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1 이상 5 이하로 입력해주세요.";
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
