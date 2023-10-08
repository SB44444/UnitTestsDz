package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {

    SomeService service;

    @BeforeEach
    void setUp() {
        service = new SomeService();
    }


    // 3.1.
    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals(service.fizzBuzz(12), "Fizz");

    }

    @Test
    void multipleFiveNotThreeReturnsFizz() {
        assertEquals(service.fizzBuzz(20), "Buzz");
    }

    @Test
    void multipleFiveAndThreeReturnsFizz() {
        assertEquals(service.fizzBuzz(15), "FizzBuzz");
    }

    @Test
    void notMultipleFiveAndThreeReturnsI() {
        assertEquals(service.fizzBuzz(8), "8");
    }

    // 3.2.
    @Test
    void testFirstList6() {
        SomeService service = new SomeService();
        int[] numbs = {6, 5, 65, 4, 75};
        assertTrue(service.firstLast6(numbs));

    }

    @Test
    void testLastList6() {
        int[] numbs = {1, 5, 10, 4, 6};
        assertTrue(service.firstLast6(numbs));

    }

    @Test
    void testNotFirsLastList6() {
        int[] numbs = {1, 5, 10, 4, 20};
        assertFalse(service.firstLast6(numbs));

    }

    /**
     * @apiNote Корректность и границы расчета скидки
     */

    @ParameterizedTest
    @CsvSource({"50, 1000", "100, 0", "0, 2000"})
    void testCorrectDiscount(int discount, int result) {
        assertThat(service.calculatingDiscount(2000.0, discount))
                .isEqualTo(result); // обычная скидка
    }

    /**
     * @apiNote Процент скидки больше 100% или меньше 0%
     */

    @ParameterizedTest
    @ValueSource(ints = {-10, 101})
    void InsufficientDiscountAmountTest(int discount) {
        assertThatThrownBy(() ->
                service.calculatingDiscount(2000.0, discount))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    /**
     * @apiNote Тесты программы игры в первое число 13
     */
    @Test
    void testFullLuckySum() {
        assertEquals(service.luckySum(1, 2, 10), 13);
    }

    @Test
    void testFirstLuckySum() {
        assertEquals(service.luckySum(13, 2, 10), 12);
    }

    @Test
    void testSecondarilySum() {
        assertEquals(service.luckySum(1, 13, 10), 11);
    }

    @Test
    void testThirdLuckySum() {
        assertEquals(service.luckySum(1, 2, 13), 3);
    }

    @Test
    void testAnyLuckySum() {
        assertEquals(service.luckySum(13, 13, 13), 26);
    }

}

