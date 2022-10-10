package racingcar.models;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Racing {
    private final Car[] cars;
    private GameResultRepository results;
    private final int gameCount;

    public Racing(RacingRequestVO vo) {
        this.cars = vo.getCars();
        this.gameCount = vo.getGameCount();
    }

    public Car[] getCars() {
        return cars;
    }

    public GameResultRepository getResults() {
        return this.results;
    }

    public Car[] getWinners() {
        HashMap<Car, Integer> scores = this.results.getScores();
        Car[][] memo = new Car[this.gameCount][this.cars.length];
        for (Car car : this.results.getScores().keySet()) {
            int score = scores.get(car);
            int sameScoreCarNum = memo[score].length;
            memo[score][sameScoreCarNum] = car;
        }
        return memo[this.results.maximumScore()];
    }

    public boolean calculateForwardOrNot() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber > 4;
    }

    public GameResult runSingleGame() {
        GameResult result = new GameResult(this.cars);
        for (Car car : this.cars) {
            result.addResult(car, this.calculateForwardOrNot());
        }
        return result;
    }

    public void run() {
        GameResult[] results = new GameResult[this.gameCount];
        for (int i = 0; i < this.gameCount; i++) {
            results[i] = this.runSingleGame();
        }
        this.results = new GameResultRepository(results);
    }
}
