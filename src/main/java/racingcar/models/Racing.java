package racingcar.models;

public class Racing {
    private Car[] cars;
    private int gameCount;

    public Racing(RacingRequestVO vo) {
        this.cars = vo.getCars();
        this.gameCount = vo.getGameCount();
    }

    public Car[] getCars() {
        return cars;
    }

    public GameResult[] getResults() {}

    public Car[] getWinners() {}

    public void run() {}
}
