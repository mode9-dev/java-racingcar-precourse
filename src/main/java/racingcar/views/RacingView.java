package racingcar.views;

import racingcar.models.Car;
import racingcar.models.GameResult;
import racingcar.models.Racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RacingView implements View {
    private HashMap<String, Object> context;

    public RacingView(HashMap<String, Object> context) {
        this.context = context;
    }
    @Override
    public void render() {
        System.out.println("게임 실행 결과\n");
        Racing racing = this.context.get("racing");
        for (GameResult result : racing.getResults()) {
            System.out.println(result.toString());
        }
        Car[] cars = racing.getWinners();
        ArrayList<String> arrNames = new ArrayList<>();
        for (Car car : cars) {
            arrNames.add(car.getName());
        }
        System.out.printf("최종 우승자: %s", String.join(",", arrNames));
    }

    @Override
    public HashMap<String, String> getRequestData() {
        return new HashMap<>();
    }
}
