package racingcar.models;

public class CarGameResult {
    private final Car car;
    private final short score;

    public CarGameResult(Car car, short score) {
        this.car = car;
        this.score = score;
    }

    public short getScore() {
        return score;
    }

    public Car getCar() {
        return car;
    }
}
