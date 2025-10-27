package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNamesTest {

    @Test
    void 팩토리메서드_from으로_인스턴스를_생성한다() {
        // given
        String input = "pobi,woni,jun";

        // when
        CarNames carNames = CarNames.from(input);

        // then
        assertThat(carNames).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,", "pobi,woni,  ", "pobi,,woni", ",pobi,woni"})
    void 자동차_이름에_공백이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa,pobi,woni", "pobi,woni,elsakim"})
    void 자동차_이름이_5글자_초과하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,pobi", "pobi,pobi"})
    void 자동차_이름에_중복이_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> CarNames.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복일 수 없습니다.");
    }
}