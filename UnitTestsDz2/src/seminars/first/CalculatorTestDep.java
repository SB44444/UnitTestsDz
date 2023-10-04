package seminars.first;

import org.junit.Test;
import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CalculatorTestDep {

    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

    }



        // Задание из 2 лекции: Добавьте функцию возведения в степень в калькулятор и протестируйте

        @Test
        public void CalculatorTestPow(){
        assertThat(Calculator.pow(10, 0)).isEqualTo(1);
        assertThat(Calculator.pow(10, 1)).isEqualTo(10);
        assertThat(Calculator.pow(2, 8)).isEqualTo(256);
        assertThat(Calculator.pow(2, -1)).isEqualTo(0.5); // todo: Ошибка вычисления отрицательной степени

    }

    @Test
    public void CalculatorTestMaxMin() {
        //   Проверка максимального и минимального значения int

        assert Integer.MAX_VALUE == Calculator.calculation(Integer.MAX_VALUE - 1, 1, '+');
        assert Integer.MIN_VALUE == Calculator.calculation(Integer.MIN_VALUE + 1, -1, '+');
        // Проверка для максимума
        try {
            Calculator.calculation(Integer.MAX_VALUE, 1, '+');
            assert false; // Тест пройден, стек не переполнен
        } catch (ArithmeticException e) {
            assert true; // Не прошел тест стек переполнен
        }
        // Проверка для максимума
        try {
            Calculator.calculation(Integer.MIN_VALUE, -1, '-');
            assert false; // Тест пройден, стек не переполнен
        } catch (ArithmeticException e) {
            assert true; // Не прошел тест стек переполнен
        }

        // Проверка исключения при делении на ноль
        try {
            Calculator.calculation(1, 0, '/');
            assert false; // Не прошел тест, при делении на ноль нет исключения
        } catch (ArithmeticException e) {
            assert true; // Тест пройден, при делении на ноль есть исключение
        }

        // Проверка

        try {
            Calculator.calculation(1, 0, 'x');
            assert false; // Не прошел тест, нет исключения при ошибочном операторе
        } catch (IllegalStateException e) {
            assert true; // Тест пройден, выпало исключение при вводе ошибочного оператора
        }
    }


        @Test
        public void testPowMathPositive(){
            assertEquals(8.0, Calculator.powMath(2.0, 3.0), 0.001);
        }

        @Test
        public void testPowMathZeroNumberPow(){
            assertEquals(1.0, Calculator.powMath(2.0, 0.0), 0.001);
        }

        @Test
        public void testPowMathOneNumberPow(){
            assertEquals(2.0, Calculator.powMath(2.0, 1.0), 0.001);
        }

        @Test
        public void testPowMathNegativeNumber(){
            assertEquals(-8.0, Calculator.powMath(-2.0, 3.0), 0.001);
        }

        @Test
        public void testPowMathNegativeNumberPow(){
            assertEquals(0.5, Calculator.powMath(2.0, -1.0), 0.001);
        }




        @Test
        public void CalculatorTestDep1(){
            //    Дз 1
            //    Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
            //    Примерная сигнатура и тело метода:
            assertThatThrownBy(() ->
                    Calculator.calculatingDiscount(-1000, 50))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Сумма покупки не может быть отрицательной");

            assertThatThrownBy(() ->
                    Calculator.calculatingDiscount(1000, -10))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

            assertThatThrownBy(() ->
                    Calculator.calculatingDiscount(1000, 101))
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");

            assertThat(Calculator.calculatingDiscount(1000, 25)).isEqualTo(750);
            assertThat(Calculator.calculatingDiscount(1000, 100)).isEqualTo(0);
            assertThat(Calculator.calculatingDiscount(1000, 0)).isEqualTo(1000);
        }
    }

