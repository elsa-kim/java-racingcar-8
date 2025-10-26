package racingcar.domain;

import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        String input = "pobi";

        // when
        Car car = Car.of(input);

        // then
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "popopo"})
    void 팩토리메서드_of로_인스턴스_생성시_빈값이나_5글자초과하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Car.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

    @Test
    void 전진_또는_정지된_상태로_변환한다() {
        // given
        Car car = Car.of("pobi");

        // when
        car.moveCar();

        // then
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차의_정보를_반환한다() {
        // given
        String name = "pobi";
        Car car = Car.of(name);

        // when
        Map<String, Integer> info = car.getStatus();

        // then
        assertThat(info).isEqualTo(Map.of(name, 0));
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 1", "3, 3"})
    void 매개변수로_받은_값과_해당_차의_위치중_최대값을_반환한다(int maxPosition, int expectedPosition) {
        // given
        Car car = Car.of("pobi");

        // when
        int result = car.maxPosition(maxPosition);

        // then
        assertThat(result).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "3, false"})
    void 해당_자동차가_우승자인지_판별한다(int winnerPosition, boolean expectedResult) {
        // given
        Car car = Car.of("pobi");

        // when
        boolean result = car.isWinner(winnerPosition);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

}