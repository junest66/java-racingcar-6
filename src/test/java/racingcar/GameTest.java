package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @Test
    void 모든_자동차가_전진_확인() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(7));
        Car car3 = new Car("woni", new TestNumberGenerator(9));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        game = new Game(cars, 1);
        game.moveAllCarsOnce();
        assertThat(cars).allMatch(car -> car.getMoveNum() == 1);
    }

    @Test
    void 일부_자동차만_전진_확인() {
        Car car1 = new Car("pobi", new TestNumberGenerator(4));
        Car car2 = new Car("woni", new TestNumberGenerator(5));
        Car car3 = new Car("jun", new TestNumberGenerator(3));
        List<Car> cars = Arrays.asList(car1, car2, car3);
        game = new Game(cars, 1);
        game.moveAllCarsOnce();
        assertThat(car1.getMoveNum()).isEqualTo(1);
        assertThat(car2.getMoveNum()).isEqualTo(1);
        assertThat(car3.getMoveNum()).isEqualTo(0);
    }
}
