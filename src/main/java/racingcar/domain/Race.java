package racingcar.domain;

public class Race {
    private static final String INVALID_NUMBER_INPUT_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INVALID_RACE_COUNT_MESSAGE = "시도할 횟수는 양수만 가능합니다.";

    private final int raceCount;

    private Race(int raceCount) {
        validateCount(raceCount);
        this.raceCount = raceCount;
    }

    public static Race of(String input) {
        try {
            int raceCount = Integer.parseInt(input);
            return new Race(raceCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT_MESSAGE, e);
        }
    }

    public boolean isRaceOngoing(int currentRound) {
        return currentRound <= raceCount;
    }

    private void validateCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
    }
}
