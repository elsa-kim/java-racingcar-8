package racingcar.domain;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 팩토리메서드_from로_인스턴스를_생성한다() {
        // given
        CarNames carNames = CarNames.from("pobi,woni,jun");

        // when
        Cars cars = Cars.from(carNames);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 자동자_이름을_두개_미만으로_입력시_예외가_발생한다() {
        // given
        CarNames carNames = CarNames.from("pobi");

        // when & then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 입력해주세요.");
    }

    @Test
    void 자동차별로_전진하거나_그대로인_위치를_가진다() {
        // given
        CarNames carNames = CarNames.from("pobi,woni,jun");
        Cars cars = Cars.from(carNames);

        // when
        cars.move();

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 우승자_이름을_리스트로_반환한다() {
        // given
        CarNames carNames = CarNames.from("pobi,woni,jun");
        Cars cars = Cars.from(carNames);

        // when
        List<String> winners = cars.findWinner();

        // then
        assertThat(winners).hasSize(3);
    }

}