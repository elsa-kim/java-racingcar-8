package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        CarName carName = CarName.of("pobi");

        // when
        Car car = Car.of(carName);

        // then
        assertThat(car).isNotNull();
    }

    @Test
    void 전진_또는_정지된_상태로_변환한다() {
        // given
        CarName carName = CarName.of("pobi");
        Car car = Car.of(carName);

        // when
        car.moveCar();

        // then
        assertThat(car).isNotNull();
    }
}