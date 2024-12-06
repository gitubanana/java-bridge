package bridge.service;

import static bridge.constant.BridgeProperty.MAX_BRIDGE_SIZE;
import static bridge.constant.BridgeProperty.MIN_BRIDGE_SIZE;
import static bridge.constant.ErrorMessage.NOT_A_NUMBER;
import static bridge.constant.ErrorMessage.TOO_LONG_BRIDGE_SIZE;
import static bridge.constant.ErrorMessage.TOO_SHORT_BRIDGE_SIZE;

public class BridgeSizeService {
    public static int parse(String line) {
        final int length = toInteger(line);

        validate(length);
        return length;
    }

    private static int toInteger(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

    private static void validate(final int length) {
        validateMinLength(length);
        validateMaxLength(length);
    }

    private static void validateMinLength(final int length) {
        if (length < MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException(TOO_SHORT_BRIDGE_SIZE.getMessage());
        }
    }

    private static void validateMaxLength(final int length) {
        if (length > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(TOO_LONG_BRIDGE_SIZE.getMessage());
        }
    }
}
