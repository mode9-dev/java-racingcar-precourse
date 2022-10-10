package racingcar.models;

import java.util.HashMap;

public class GameResult {
    private final HashMap<Car, Integer> dashboard = new HashMap<>();

    public GameResult(Car[] cars) {
        for (Car car : cars) {
            this.dashboard.put(car, 0);
        }
    }

    public HashMap<Car, Integer> getDashboard() {
        return dashboard;
    }

    public void addResult(Car car, boolean success) {
        this.dashboard.put(car, success ? 1 : 0);
    }

}
