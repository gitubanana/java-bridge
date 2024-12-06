package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== BridgeMaker 테스트 ==")
public class BridgeMakerTest {
    @ParameterizedTest
    @DisplayName("무작위값을 통해 다리를 만들 수 있다.")
    @MethodSource("getBridgeMakerArguments")
    void 다리_생성(List<Integer> randomNumbers, List<String> expected) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(randomNumbers));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        assertThat(bridgeMaker.makeBridge(expected.size())).isEqualTo(expected);
    }

    static Stream<Arguments> getBridgeMakerArguments() {
        return Stream.of(
                Arguments.of(
                        List.of(BridgeMaker.UP_NUMBER, BridgeMaker.UP_NUMBER),
                        List.of(BridgeMaker.UP_STRING, BridgeMaker.UP_STRING)
                ),
                Arguments.of(
                        List.of(BridgeMaker.UP_NUMBER, BridgeMaker.DOWN_NUMBER, BridgeMaker.DOWN_NUMBER),
                        List.of(BridgeMaker.UP_STRING, BridgeMaker.DOWN_STRING, BridgeMaker.DOWN_STRING)
                ),
                Arguments.of(
                        List.of(BridgeMaker.DOWN_NUMBER, BridgeMaker.DOWN_NUMBER, BridgeMaker.UP_NUMBER),
                        List.of(BridgeMaker.DOWN_STRING, BridgeMaker.DOWN_STRING, BridgeMaker.UP_STRING)
                )
        );
    }
}