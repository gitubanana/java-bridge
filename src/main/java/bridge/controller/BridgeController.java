package bridge.controller;

import static bridge.constant.BridgeProperty.RESTART;
import static bridge.constant.OutputMessage.BRIDGE_GAME_START;
import static bridge.constant.OutputMessage.BRIDGE_LENGTH;
import static bridge.constant.OutputMessage.PLAYER_MOVE;
import static bridge.constant.OutputMessage.PLAY_AGAIN;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.util.Task;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.println(BRIDGE_GAME_START.getMessage());
        BridgeGame bridgeGame = makeBridgeGame();

        while (bridgeGame.isNotOver()) {
            boolean moveSuccess = bridgeGame.move(readMove());
            outputView.printMap(bridgeGame);

            if (timeToQuit(moveSuccess, bridgeGame)) {
                break;
            }
        }
        outputView.printResult(bridgeGame);
    }

    private BridgeGame makeBridgeGame() {
        int bridgeSize = readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    private int readBridgeSize() {
        return Task.runTillNoException(
                () -> {
                    outputView.println(BRIDGE_LENGTH.getMessage());
                    return inputView.readBridgeSize();
                },
                outputView
        );
    }

    private String readMove() {
        return Task.runTillNoException(
                () -> {
                    outputView.println(PLAYER_MOVE.getMessage());
                    return inputView.readMoving();
                },
                outputView
        );
    }

    private boolean timeToQuit(boolean moveSuccess, BridgeGame bridgeGame) {
        if (moveSuccess) {
            return false;
        }
        if (readAnswerToEnd().equals(RESTART)) {
            bridgeGame.retry();
            return false;
        }
        return true;
    }

    private String readAnswerToEnd() {
        return Task.runTillNoException(
                () -> {
                    outputView.println(PLAY_AGAIN.getMessage());
                    return inputView.readGameCommand();
                },
                outputView
        );
    }
}
