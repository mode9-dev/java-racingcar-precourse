package racingcar.communications;

import racingcar.views.View;

public class Response {
    private View view;

    public Response(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void render() {
        this.view.render();
    }
}
