package racingcar.models;


import java.util.Collections;
import java.util.HashMap;

public class GameResultRepository {
    private final GameResult[] results;

    private void merge(HashMap<Car, Integer> map1, HashMap<Car, Integer> map2) {
        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
    }

    public GameResultRepository(GameResult[] results) {
        this.results = results;
    }

    public HashMap<Car, Integer> getScores() {
        HashMap<Car, Integer> scores = new HashMap<>();
        for (GameResult result : this.results) {
            this.merge(scores, result.getDashboard());
        }
        return scores;
    }

    public String scoreToString(HashMap<Car, Integer> scores) {
        String[] strings = new String[scores.size()];
        int i = 0;
        for (Car car : scores.keySet()) {
            int score = scores.get(car);
            strings[i] = String.format("%s : %s", car.getName(), new String(new char[score]).replace("\0", "-"));
            i++;
        }
        return String.join("\n", strings);
    }

    @Override
    public String toString() {
        HashMap<Car, Integer> scoreMemo = new HashMap<>();
        String[] result = new String[this.results.length];
        for (int i = 0; i < this.results.length; i++) {
            GameResult gameResult = this.results[i];
            this.merge(scoreMemo, gameResult.getDashboard());
            result[i] = this.scoreToString(scoreMemo);
        }
        return String.join("\n", result);
    }
}
