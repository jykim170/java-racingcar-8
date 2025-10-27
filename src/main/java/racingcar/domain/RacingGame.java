package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final MoveStrategy strategy;

    private RacingGame(Cars cars, MoveStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static RacingGame of(List<String> names, MoveStrategy strategy) {
        List<Car> list = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingGame(new Cars(list), strategy);
    }

    public void raceOnce() {
        for (Car car : cars.asList()) {
            car.move(strategy.canMove());
        }
    }

    public List<Car> snapshot() {
        return cars.asList();
    }

    public List<String> winnerNames() {
        return cars.findWinnersNames();
    }
}
