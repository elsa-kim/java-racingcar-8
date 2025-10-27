package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @Test
    void 팩토리메서드_generate로_초기_위치의_인스턴스를_생성한다() {
        // when
        CarPosition position = CarPosition.generate();

        // then
        assertThat(position).isNotNull();
    }

    @Test
    void 팩토리메서드_nextPosition으로_기존_위치에서_전진한_위치의_인스턴스를_생성한다() {
        // given
        CarPosition position = CarPosition.generate();

        // when
        CarPosition nextPosition1 = position.nextPosition();
        CarPosition nextPosition2 = nextPosition1.nextPosition();

        // then
        assertAll(
                () -> assertThat(nextPosition1.getPosition()).isEqualTo(1),
                () -> assertThat(nextPosition2.getPosition()).isEqualTo(2)
        );
    }

}