package racingcar.models;

import java.util.Collections;
import java.util.HashMap;

public class GameResultRepository {
    private GameResult[] results;

    private void merge(HashMap<Car, Integer> map1, HashMap<Car, Integer> map2) {
        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
    }

    public GameResultRepository(GameResult[] results) {
        this.results = results;
    }

    public GameResult[] getResults() {
        return results;
    }

    public int maximumScore() {
        return Collections.max(this.getScores().values());
    }

    public HashMap<Car, Integer> getScores() {
        HashMap<Car, Integer> scores = new HashMap<Car, Integer>();
        for (GameResult result : this.results) {
            this.merge(scores, result.getDashboard());
        }
        return scores;
    }
}
