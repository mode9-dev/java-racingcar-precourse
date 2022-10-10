package racingcar.controllers;

import racingcar.communications.Request;
import racingcar.communications.Response;
import racingcar.models.Car;
import racingcar.models.Racing;
import racingcar.models.RacingRequestVO;
import racingcar.views.RacingView;
import racingcar.views.View;

import java.util.HashMap;
import java.util.regex.Pattern;

public class RacingController extends Controller {
    public View getView(Request request) {
        return new RacingView();
    }

    public Car[] cleanCarNames(String rawCarNames) {
        if (rawCarNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름을 입력해주세요.");
        }
        String[] carNames = rawCarNames.split(",");
        Car[] result = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            result[i] = new Car(carNames[i]);
        }
        return result;
    }

    public int cleanGameCount(String rawGameCount) {
        Pattern pattern = Pattern.compile("^[1-9]+$");
        boolean isNumeric = pattern.matcher(rawGameCount).matches();
        if (!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 올바른 게임 횟수를 입력해주세요");
        }
        return Integer.parseInt(rawGameCount);
    }

    public RacingRequestVO clean(HashMap<String, String> data) {
        Car[] cars = this.cleanCarNames(data.getOrDefault("carNames", ""));
        int gameCount = this.cleanGameCount(data.getOrDefault("gameCount", "0"));
        return new RacingRequestVO(cars, gameCount);
    }

    public Response post(Request request) {
        HashMap<String, String> body = request.getBody();
        RacingRequestVO cleanedData = this.clean(body);

        Racing racing = new Racing(cleanedData);
        racing.run();
        HashMap<String, Object> context = this.getContextData(request);
        context.put("racing", racing);
        return new Response(this.getView(request), context);
    }

}
