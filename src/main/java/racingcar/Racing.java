package racingcar;

import java.util.List;
import java.util.Map;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
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

    private Cars settingCars() {
        CarNames carNames = readCarNames();
        return Cars.from(carNames);
    }

    private CarNames readCarNames() {
        outputView.printCarNameRequestMessage();
        String input = inputView.readInput();

        return CarNames.from(input);
    }

    private Race settingRace() {
        outputView.printRaceCountRequestMessage();
        RaceCount raceCount = RaceCount.of(inputView.readInput());
        
        return Race.of(raceCount);
    }

    private void playRace(Race race, Cars cars) {
        outputView.printRoundStartMessage();
        
        while (race.isRaceOngoing()) {
            cars.move();
            showRoundResult(cars);
        }
    }

    private void showRoundResult(Cars cars) {
        List<Map<String, Integer>> carsStatus = convertToCarStatusMaps(cars);
        outputView.printRound(carsStatus);
    }

    private List<Map<String, Integer>> convertToCarStatusMaps(Cars cars) {
        return cars.getCars().stream()
                .map(car -> Map.of(car.getName(), car.getPosition()))
                .toList();
    }

    private void determineWinners(Cars cars) {
        List<String> winner = cars.findWinner();
        outputView.printWinner(winner);
    }
}
