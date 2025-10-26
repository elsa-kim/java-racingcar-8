package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @Test
    void 팩토리메서드_generate로_초기_위치의_인스턴스를_생성한다(){
        // when
        CarPosition position = CarPosition.generate();

        // then
        assertThat(position).isNotNull();
    }

    @Test
    void 팩토리메서드_nextPosition으로_기존_위치에서_전진한_위치의_인스턴스를_생성한다(){
        // given
        CarPosition position = CarPosition.generate();

        // when
        CarPosition nextPosition = CarPosition.nextPosition(position);

        // then
        assertAll(
                () -> assertThat(nextPosition).isNotNull(),
                () -> assertThat(nextPosition.getPosition()).isEqualTo(1)
        );
    }

}