package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> cars) {
        this.values = new ArrayList<>(cars);
    }

    public List<Car> asList() {
        return new ArrayList<>(values);
    }

    public int maxPosition() {
        return values.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    public List<String> findWinnersNames() {
        int max = maxPosition();
        return values.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
