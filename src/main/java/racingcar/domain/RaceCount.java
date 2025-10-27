package racingcar.domain;

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

    private void validatePositiveRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_ERROR_MESSAGE);
        }
    }
}
