package racingcar.domain;

public class Race {
    private final RaceCount raceCount;
    private CurrentCount currentCount;

    private Race(RaceCount raceCount, CurrentCount currentCount) {
        this.raceCount = raceCount;
        this.currentCount = currentCount;
    }

    public static Race of(String input) {
        return new Race(RaceCount.of(input), CurrentCount.generate());
    }

    public boolean isRaceOngoing() {
        this.currentCount = CurrentCount.nextRound(currentCount);

        return currentCount.getCount() <= raceCount.getCount();
    }

}
