package racingcar.domain;

public class Race {
    private final RaceCount raceCount;
    private int currentCount = 0;

    private Race(RaceCount raceCount) {
        this.raceCount = raceCount;
    }

    public static Race of(RaceCount raceCount) {
        return new Race(raceCount);
    }

    public boolean isRaceOngoing() {
        this.currentCount++;
        return currentCount <= raceCount.getCount();
    }
}
