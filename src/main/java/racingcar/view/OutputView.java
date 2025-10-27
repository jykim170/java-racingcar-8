package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winnerNames) {
        String joined = winnerNames.stream().collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + joined);
    }
}

