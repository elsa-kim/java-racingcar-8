package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printCarNameRequestMessage();
        String carNames = inputView.readInput();
        Cars cars = Cars.of(carNames);
        outputView.printRaceCountRequestMessage();
        Race race = Race.of(inputView.readInput());
        outputView.printRoundStartMessage();
        int currentRound = 1;
        while (race.isRaceOngoing(currentRound)) {
            cars.move();
            outputView.printRound(cars.getCarsStatus());
            currentRound++;
        }
        String winner = cars.findWinner();
    }
}
