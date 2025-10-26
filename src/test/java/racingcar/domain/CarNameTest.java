package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        String input = "pobi";

        // when
        CarName carName = CarName.of(input);

        // then
        assertThat(carName).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"popopo", "", "  "})
    void 인스턴스_생성시_공백이나_5자_초과한_input값이_들어오면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> CarName.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1 이상 5 이하로 입력해주세요.");
    }

}