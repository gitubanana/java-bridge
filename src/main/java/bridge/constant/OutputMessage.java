package bridge.constant;

public enum OutputMessage {
    BRIDGE_GAME_START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    PLAYER_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    PLAY_AGAIN("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    MARK("[ %s ]"),
    END_GAME("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s"),
    ROUND_COUNT("총 시도한 횟수: %d"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String format(Object... objects) {
        return String.format(message, objects);
    }

    public String getMessage() {
        return message;
    }
}
