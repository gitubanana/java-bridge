package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    public static final int DOWN_NUMBER = 0;
    public static final int UP_NUMBER = 1;
    public static final String DOWN_STRING = "D";
    public static final String UP_STRING = "U";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        List<String> bridge = new ArrayList<>(size);

        while (bridge.size() < size) {
            bridge.add(toDirection(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private String toDirection(final int number) {
        if (number == DOWN_NUMBER) {
            return DOWN_STRING;
        }
        return UP_STRING;
    }
}
