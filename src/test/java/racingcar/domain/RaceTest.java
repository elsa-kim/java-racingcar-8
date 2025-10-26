package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        RaceCount raceCount = RaceCount.of("3");

        // when
        Race race = Race.of(raceCount);

        // then
        assertThat(race).isNotNull();
    }

    @Test
    void 레이싱이_진행중인지_여부를_반환한다() {
        // given
        Race race = Race.of(RaceCount.of("3"));

        // when
        boolean result = race.isRaceOngoing();

        // then
        assertThat(result).isTrue();
    }

}