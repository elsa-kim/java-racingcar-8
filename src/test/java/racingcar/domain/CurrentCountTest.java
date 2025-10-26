package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;

class CurrentCountTest {

    @Test
    void 팩토리메서드_generate로_인스턴스를_생성한다() {
        // when
        CurrentCount currentCount = CurrentCount.generate();

        // then
        assertThat(currentCount).isNotNull();
    }

    @Test
    void 팩토리메서드_nextRound로_다음라운드_인스턴스를_생성한다() {
        // given
        CurrentCount currentCount = CurrentCount.generate();

        // when
        CurrentCount nextCount = CurrentCount.nextRound(currentCount);

        // then
        assertAll(
                () -> assertThat(nextCount).isNotNull(),
                () -> assertThat(nextCount.getCount()).isEqualTo(1)
        );
    }

}