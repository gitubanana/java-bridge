package bridge.service;

import static bridge.constant.ErrorMessage.NOT_A_NUMBER;
import static bridge.constant.ErrorMessage.TOO_LONG_BRIDGE_SIZE;
import static bridge.constant.ErrorMessage.TOO_SHORT_BRIDGE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("== BridgeSizeService 테스트 ==")
public class BridgeSizeServiceTest {
    @ParameterizedTest
    @DisplayName("다리 길이를 잘 파싱할 수 있다.")
    @MethodSource("getParseArguments")
    void 다리_길이_파싱(String line, int expected) {
        assertThat(BridgeSizeService.parse(line))
                .isEqualTo(expected);
    }

    static Stream<Arguments> getParseArguments() {
        return Stream.of(
                Arguments.of("3", 3),
                Arguments.of("4", 4),
                Arguments.of("5", 5),
                Arguments.of("15", 15),
                Arguments.of("20", 20)
        );
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닐 경우 예외를 발생시킬 수 있다.")
    @ValueSource(strings = {"", "abc", "a4", "hi"})
    void 숫자_아님(String line) {
        assertThatThrownBy(() -> BridgeSizeService.parse(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("다리의 길이가 작을 경우 예외를 발생시킬 수 있다.")
    @ValueSource(strings = {"-1", "0", "1", "2"})
    void 다리_길이_작음(String line) {
        assertThatThrownBy(() -> BridgeSizeService.parse(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_SHORT_BRIDGE_SIZE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("다리의 길이가 클 경우 예외를 발생시킬 수 있다.")
    @ValueSource(strings = {"21", "25", "100"})
    void 다리_길이_큼(String line) {
        assertThatThrownBy(() -> BridgeSizeService.parse(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_LONG_BRIDGE_SIZE.getMessage());
    }
}
