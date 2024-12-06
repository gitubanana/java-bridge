package bridge.service;

import static bridge.constant.BridgeProperty.DOWN_STRING;
import static bridge.constant.BridgeProperty.UP_STRING;
import static bridge.constant.ErrorMessage.INVALID_ANSWER;

public class MoveService {
    public static void validate(String message) {
        if (message.equals(UP_STRING) || message.equals(DOWN_STRING)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_ANSWER.getMessage());
    }
}
