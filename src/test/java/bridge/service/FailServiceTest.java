package bridge.service;

import static bridge.constant.ErrorMessage.INVALID_ANSWER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== FailService 테스트 ==")
public class FailServiceTest {
    @ParameterizedTest
    @DisplayName("올바른 문자열이 아니라면 예외를 발생시킬 수 있다.")
    @ValueSource(strings = {"HI", "q", "r"})
    void 올바른_문자열_아님(String line) {
        assertThatThrownBy(() -> FailService.validate(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ANSWER.getMessage());
    }
}
