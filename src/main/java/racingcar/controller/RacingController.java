package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.util.Validators;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    public void run() {
        List<String> names = Validators.parseNames(InputView.readNames());
        int tryCount = Validators.parseTryCount(InputView.readTryCount());

        OutputView.printStart();

        RacingGame game = RacingGame.of(names, new RandomMoveStrategy());
        for (int i = 0; i < tryCount; i++) {
            game.raceOnce();
            OutputView.printRound(game.snapshot());
        }

        OutputView.printWinners(game.winnerNames());
    }
}
