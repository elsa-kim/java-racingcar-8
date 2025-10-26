package racingcar.domain;

public class CurrentCount {

    private final int currentCount;

    private CurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public static CurrentCount generate() {
        return new CurrentCount(0);
    }

    public static CurrentCount nextRound(CurrentCount currentCount) {
        return new CurrentCount(currentCount.getCount() + 1);
    }

    public int getCount() {
        return currentCount;
    }
}
