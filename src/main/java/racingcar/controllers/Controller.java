package racingcar.controllers;

import racingcar.communications.Method;
import racingcar.communications.Request;
import racingcar.communications.Response;

public interface Controller {

    public default Response dispatch(Request request) {

        Method reqMethod = request.getMethod();

        if (reqMethod == Method.GET) {
            return this.get(request);
        }
        return this.post(request);
    }

    public Response get(Request request);
    public Response post(Request request);
}
