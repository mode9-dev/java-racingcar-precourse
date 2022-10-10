package racingcar;

import racingcar.communications.Method;
import racingcar.communications.Request;
import racingcar.communications.Response;
import racingcar.controllers.Controller;
import racingcar.controllers.GameLandingController;
import racingcar.controllers.RacingController;
import racingcar.views.View;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        Request req = new Request(Method.GET, new HashMap<>());

        Controller landingController = new GameLandingController();
        Response response = landingController.dispatch(req);
        response.render();

        View view = response.getView();
        HashMap<String, String> reqData = view.getRequestData();
        Controller racingController = new RacingController();
        Response response1 = racingController.post(new Request(Method.POST, reqData));
        response1.render();


    }
}
