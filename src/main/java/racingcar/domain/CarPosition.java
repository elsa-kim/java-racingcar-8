package racingcar.domain;

public class CarPosition {
    private static final String INVALID_POSITION_MESSAGE = "잘못된 위치값입니다.";

    private final int position;

    private CarPosition(int position) {
        validateNonNegative(position);
        this.position = position;
    }

    public static CarPosition generate() {
        return new CarPosition(0);
    }

    public static CarPosition nextPosition(CarPosition position) {
        return new CarPosition(position.getPosition() + 1);
    }

    public int getPosition() {
        return position;
    }

    private void validateNonNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION_MESSAGE);
        }
    }
}
