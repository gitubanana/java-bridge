package bridge.service;

import static bridge.constant.ErrorMessage.INVALID_ANSWER;

import bridge.BridgeMaker;

public class MoveService {
    public static void validate(String message) {
        if (message.equals(BridgeMaker.UP_STRING) || message.equals(BridgeMaker.DOWN_STRING)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_ANSWER.getMessage());
    }
}
