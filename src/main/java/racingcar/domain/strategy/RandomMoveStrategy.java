package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }
}
