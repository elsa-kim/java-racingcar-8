package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RaceCountTest {

    @Test
    void 팩토리메서드_of로_인스턴스를_생성한다() {
        // given
        String input = "5";

        // when
        RaceCount raceCount = RaceCount.of(input);

        // then
        assertThat(raceCount).isNotNull();
    }

    @Test
    void 인스턴스_생성시_숫자가_아닌_값을_넣으면_예외가_발생한다() {
        // given
        String input = "오";

        // when & then
        assertThatThrownBy(() -> RaceCount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-3"})
    void 인스턴스_생성시_양수가_아닌_값을_넣으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> RaceCount.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양수만 가능합니다.");
    }
}