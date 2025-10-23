package racingcar;

import racingcar.view.OutputView;

public class Racing {
    private final OutputView outputView = new OutputView();

    public void run(){
        outputView.printCarNameRequestMessage();
    }
}
