package bridge.util;

import bridge.view.OutputView;

public interface Task<T> {
    static <T> T runTillNoException(Task<T> task, OutputView outputView) {
        while (true) {
            try {
                return task.run();
            } catch (IllegalArgumentException e) {
                outputView.println(e.getMessage());
            }
        }
    }

    T run();
}
