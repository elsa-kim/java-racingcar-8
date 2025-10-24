package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        Cars cars = settingCars();
        Race race = settingRace();
        playRace(race, cars);
        determineWinners(cars);
    }

    private void determineWinners(Cars cars) {
        List<String> winner = cars.findWinner();
        outputView.printWinner(winner);
    }

    private void playRace(Race race, Cars cars) {
        outputView.printRoundStartMessage();
        int currentRound = 1;
        while (race.isRaceOngoing(currentRound)) {
            cars.move();
            outputView.printRound(cars.getCarsStatus());
            currentRound++;
        }
    }

    private Race settingRace() {
        outputView.printRaceCountRequestMessage();
        return Race.of(inputView.readInput());
    }

    private Cars settingCars() {
        outputView.printCarNameRequestMessage();
        return Cars.of(inputView.readInput());
    }
}
