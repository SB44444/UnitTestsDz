import org.assertj.core.api.Assertions;
import org.junit.Test;
import seminars.first.model.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static seminars.first.model.Calculator.calculateDiscount;

public class CalculatorTest {
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

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operator: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');
        assert 1024 == Calculator.calculation(2, 10
                , '^');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);
        assertThat(Calculator.calculation(2, 10, '^')).isEqualTo(1024);

        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
        assertThatThrownBy(() ->
                Calculator.calculation(8, 4, '_')
        ).isInstanceOf(IllegalStateException.class);

        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
        System.out.println(Calculator.squareRootExtraction(169));
    }

    // Проверка расчета скидки
    @Test
    public void testCalculateDiscount() {

        double customOrder1 = calculateDiscount(5000.0, 10.0);
        double customOrder2 = calculateDiscount(2000.0, 50.0);
        double customOrder3 = calculateDiscount(2999.0, 0.0);
        Assertions.assertThat(customOrder1).isEqualTo(4500.0);
        Assertions.assertThat(customOrder2).isEqualTo(1000.0);
        Assertions.assertThat(customOrder3).isEqualTo(2999.0);
        System.out.println(customOrder1);
        System.out.println(customOrder2);
        System.out.println(customOrder3);

    }

    // Проверка на ожидаемое исключение при недопустимых аргументах
    @Test
    public void testCalculateDiscountExeptn() {
        Assertions.assertThatThrownBy(() -> calculateDiscount(-1.0, 0.0))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма заказа меньше 0");
        Assertions.assertThatThrownBy(() -> calculateDiscount(10.0, -2.2))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма скидки меньше 0");
        Assertions.assertThatThrownBy(() -> calculateDiscount(10.0, 50.01))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("В компании запрещены скидки более 50%");
    }
}


