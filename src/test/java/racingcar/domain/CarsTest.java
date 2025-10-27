package racingcar.domain;

import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @Test
    void 팩토리메서드_of로_Cars_객체를_생성한다() {
        // given
        String input = "pobi,woni,jun";

        // when
        Cars cars = Cars.of(input);

        // when
        assertThat(cars).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,", "pobi,woni,  ", "pobi,,woni", ",pobi,woni"})
    void 자동차_이름에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Cars.of(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,pobi,woni", "pobi,woni,elsakim"})
    void 자동차_이름이_5글자_초과하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Cars.of(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,pobi", "pobi,pobi"})
    void 자동차_이름에_중복이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Cars.of(input)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복일 수 없습니다.");
    }

    @Test
    void 자동자_이름을_두개_미만으로_입력시_예외가_발생한다() {
        // given
        String input = "pobi";

        // when & then
        assertThatThrownBy(() -> Cars.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 2대 이상 입력해주세요.");
    }

    @Test
    void 자동차별로_전진하거나_그대로인_위치를_가진다() {
        // given
        Cars cars = Cars.of("pobi,woni,jun");

        // when
        cars.move();

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 자동차들의_이름과_위치정보를_반환한다() {
        // given
        Cars cars = Cars.of("pobi,woni,jun");

        // when
        List<Map<String, Integer>> info = cars.getCarsStatus();

        // then
        assertThat(info).hasSize(3);
    }

    @Test
    void 우승자_이름을_리스트로_반환한다() {
        // given
        Cars cars = Cars.of("pobi,woni,jun");

        // when
        List<String> winners = cars.findWinner();

        // then
        assertThat(winners).hasSize(3);
    }

}