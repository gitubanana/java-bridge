package bridge.model;

import static bridge.constant.BridgeProperty.UP_STRING;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String SUCCESS = "O";
    private static final String FAIL = "X";
    private static final String EMPTY = " ";
    private static final int UP_MARK_INDEX = 0;
    private static final int DOWN_MARK_INDEX = 1;

    private int roundCount = 1;
    private final List<String> bridge;
    private final List<List<String>> marks = List.of(new ArrayList<>(), new ArrayList<>());
    private int playerIndex;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean move(String direction) {
        boolean moveSuccess = direction.equals(bridge.get(playerIndex));

        mark(direction, moveSuccess);
        if (moveSuccess) {
            playerIndex++;
            return true;
        }
        return false;
    }

    private void mark(String direction, boolean moveSuccess) {
        int directionIndex = getDirectionIndex(direction);
        int otherIndex = directionIndex ^ 1;

        marks.get(otherIndex).add(EMPTY);
        marks.get(directionIndex).add(getMark(moveSuccess));
    }

    private String getMark(boolean moveSuccess) {
        if (moveSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    private int getDirectionIndex(String direction) {
        if (direction.equals(UP_STRING)) {
            return UP_MARK_INDEX;
        }
        return DOWN_MARK_INDEX;
    }

    public void retry() {
        roundCount++;
        playerIndex = 0;
        marks.forEach(List::clear);
    }

    public boolean isNotOver() {
        return playerIndex < bridge.size();
    }

    public List<List<String>> getMarks() {
        return marks;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
