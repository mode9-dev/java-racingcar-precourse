package racingcar.models;

public class RacingRequestVO {
    private Car[] cars;
    private int gameCount;

    public RacingRequestVO(Car[] cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getGameCount() {
        return gameCount;
    }
}
