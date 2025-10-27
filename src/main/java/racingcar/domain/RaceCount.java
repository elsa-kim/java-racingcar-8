package racingcar.domain;

import java.util.Objects;

public class RaceCount {
    private static final String INVALID_NUMBER_INPUT_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_RACE_COUNT_ERROR_MESSAGE = "시도할 횟수는 양수만 가능합니다.";

    private final int raceCount;

    private RaceCount(int raceCount) {
        validatePositiveRaceCount(raceCount);
        this.raceCount = raceCount;
    }

    public static RaceCount of(String input) {
        try {
            return new RaceCount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_ERROR_MESSAGE, e);
        }
    }

    public int getCount() {
        return raceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RaceCount otherRaceCount = (RaceCount) o;
        return raceCount == otherRaceCount.raceCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(raceCount);
    }

    private void validatePositiveRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_ERROR_MESSAGE);
        }
    }
}
