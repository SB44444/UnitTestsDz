package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.MainHW;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    /**
     * Тест проверяет, является ли число n чётным
     */

    @Test
    void testEvenOddNumber() {
        assertTrue(mainHW.evenOddNumber(10));
        assertFalse(mainHW.evenOddNumber(7));
    }

    /**
     * Тест проверяет, что заданное число n находится вне заданного интервала
     */

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 25, 100, 120})
    void testNumberOutInterval(int n) {
        assertFalse(mainHW.numberInInterval(n, false));
    }

    /**
     * Тест проверяет, что заданное число n находится внутри заданного интервала
     */
    @ParameterizedTest
    @ValueSource(ints = {26, 52, 99})
    void testNumberInInterval(int n) {
        assertTrue(mainHW.numberInInterval(n, true));
    }
}
