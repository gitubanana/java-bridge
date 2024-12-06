package bridge.constant;

import static bridge.constant.BridgeProperty.MAX_BRIDGE_SIZE;
import static bridge.constant.BridgeProperty.MIN_BRIDGE_SIZE;

public enum ErrorMessage {
    NOT_A_NUMBER("숫자가 아닙니다."),
    TOO_SHORT_BRIDGE_SIZE("다리의 길이는 " + MIN_BRIDGE_SIZE + "이상이어야 합니다"),
    TOO_LONG_BRIDGE_SIZE("다리의 길이는 " + MAX_BRIDGE_SIZE + "이하여야 합니다"),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
