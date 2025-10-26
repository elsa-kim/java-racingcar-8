package racingcar.domain;

public class Race {
    private final RaceCount raceCount;
    private CurrentCount currentCount;

    private Race(RaceCount raceCount, CurrentCount currentCount) {
        this.raceCount = raceCount;
        this.currentCount = currentCount;
    }

    public static Race of(RaceCount raceCount) {
        return new Race(raceCount, CurrentCount.generate());
    }

    public boolean isRaceOngoing() {
        this.currentCount = currentCount.nextRound();

        return currentCount.getCount() <= raceCount.getCount();
    }

}
