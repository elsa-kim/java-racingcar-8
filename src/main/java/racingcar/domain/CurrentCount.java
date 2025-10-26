package racingcar.domain;

public class CurrentCount {

    private final int currentCount;

    private CurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public static CurrentCount generate() {
        return new CurrentCount(0);
    }

    public CurrentCount nextRound() {
        return new CurrentCount(currentCount + 1);
    }

    public int getCount() {
        return currentCount;
    }
}
