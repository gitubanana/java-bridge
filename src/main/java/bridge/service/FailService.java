package bridge.service;

import static bridge.constant.BridgeProperty.QUIT;
import static bridge.constant.BridgeProperty.RESTART;
import static bridge.constant.ErrorMessage.INVALID_ANSWER;

public class FailService {
    public static void validate(String line) {
        if (line.equals(RESTART) || line.equals(QUIT)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_ANSWER.getMessage());
    }
}
