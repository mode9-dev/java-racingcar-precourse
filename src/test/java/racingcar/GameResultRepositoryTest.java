package racingcar;
import org.junit.jupiter.api.Test;
import racingcar.models.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultRepositoryTest {

    @Test
    public void mergeScores() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("mode9");

        GameResult gameResult1 = new GameResult(new Car[]{car1, car2});
        gameResult1.addResult(car1, false);
        gameResult1.addResult(car2, true);
        GameResult gameResult2 = new GameResult(new Car[]{car1, car2});
        gameResult2.addResult(car1, true);
        gameResult2.addResult(car2, true);
        int expectCar1Score = 1;
        int expectCar2Score = 2;

        GameResultRepository repo = new GameResultRepository(new GameResult[]{gameResult1, gameResult2});

        assertThat(repo.getScores())
                .hasSize(2)
                .containsKeys(car1, car2)
                .satisfies(scores -> {
                    assertThat(scores.get(car1)).isEqualTo(expectCar1Score);
                    assertThat(scores.get(car2)).isEqualTo(expectCar2Score);
                });

    }
}
