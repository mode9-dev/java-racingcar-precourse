package racingcar.views;

import racingcar.communications.Method;

import java.util.HashMap;

public interface View {

    public void render();

    public HashMap<String, String> getRequestData();
}
