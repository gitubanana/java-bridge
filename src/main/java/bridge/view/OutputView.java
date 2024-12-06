package bridge.view;

import static bridge.constant.OutputMessage.END_GAME;
import static bridge.constant.OutputMessage.GAME_RESULT;
import static bridge.constant.OutputMessage.MARK;
import static bridge.constant.OutputMessage.ROUND_COUNT;

import bridge.model.BridgeGame;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String SPACE_DELIMITER = " | ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public void printMap(BridgeGame bridgeGame) {
        for (List<String> mark : bridgeGame.getMarks()) {
            println(MARK.format(String.join(SPACE_DELIMITER, mark)));
        }
    }

    public void printResult(BridgeGame bridgeGame) {
        println(END_GAME.getMessage());
        printMap(bridgeGame);
        println(GAME_RESULT.format(getResult(bridgeGame)));
        println(ROUND_COUNT.format(bridgeGame.getRoundCount()));
    }

    private String getResult(BridgeGame bridgeGame) {
        if (bridgeGame.isNotOver()) {
            return FAIL;
        }
        return SUCCESS;
    }

    public void println(String message) {
        System.out.println(message);
    }
}
