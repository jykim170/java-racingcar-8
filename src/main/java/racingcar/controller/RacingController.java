package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.Validators;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void run() {
        try {
            List<String> names = readCarNames();
            int tryCount = readTryCount();
            playGame(names, tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private List<String> readCarNames() {
        return Validators.parseNames(InputView.readNames());
    }

    private int readTryCount() {
        return Validators.parseTryCount(InputView.readTryCount());
    }

    private void playGame(List<String> names, int tryCount) {
        RacingGame game = RacingGame.of(names, new RandomMoveStrategy());
        OutputView.printStart();

        for (int i = 0; i < tryCount; i++) {
            game.raceOnce();
            OutputView.printRound(game.snapshot());
        }

        OutputView.printWinners(game.winnerNames());
    }
}
