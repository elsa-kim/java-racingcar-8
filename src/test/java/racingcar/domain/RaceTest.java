package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        String input = "3";

        // when
        Race race = Race.of(input);

        // then
        assertThat(race).isNotNull();
    }

    @Test
    void 숫자가_아닌_input이_들어올경우_예외가_발생한다() {
        // given
        String input = "삼";

        assertThatThrownBy(() -> Race.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 양수가_아닌_숫자가_들어올경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Race.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수만 가능합니다.");
    }

    @Test
    void 레이싱이_진행중인지_여부를_반환한다() {
        // given
        Race race = Race.of("3");

        // when
        boolean result = race.isRaceOngoing();

        // then
        assertThat(result).isTrue();
    }

}