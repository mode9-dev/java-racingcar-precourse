package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class GameLandingView implements View {
    private HashMap<String, String> requestData;

    public GameLandingView() {
        this.requestData = new HashMap<>();
    }

    public HashMap<String, String> getRequestData() {
        return requestData;
    }

    @Override
    public void render() {
        System.out.println("경주할 자동차의 이름(이름은 쉼표(,) 기준으로 구분)");
        this.requestData.put("carNames", Console.readLine());
        System.out.println("시도할 횟수는 몇회인가요?");
        this.requestData.put("count", Console.readLine());
    }
}
