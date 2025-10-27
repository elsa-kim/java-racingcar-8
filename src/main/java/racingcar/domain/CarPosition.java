package racingcar.domain;

import java.util.Objects;

public class CarPosition {
    private static final String INVALID_POSITION_ERROR_MESSAGE = "잘못된 위치값입니다.";

    private final int position;

    private CarPosition(int position) {
        validateNonNegative(position);
        this.position = position;
    }

    public static CarPosition generate() {
        return new CarPosition(0);
    }

    public CarPosition nextPosition() {
        return new CarPosition(position + 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition otherPosition = (CarPosition) o;
        return position == otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    private void validateNonNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION_ERROR_MESSAGE);
        }
    }
}
