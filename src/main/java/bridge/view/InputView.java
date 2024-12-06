package bridge.view;

import bridge.service.BridgeSizeService;
import bridge.service.FailService;
import bridge.service.MoveService;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        return BridgeSizeService.parse(Console.readLine());
    }

    public String readMoving() {
        String move = Console.readLine();

        MoveService.validate(move);
        return move;
    }

    public String readGameCommand() {
        String command = Console.readLine();

        FailService.validate(command);
        return command;
    }
}
