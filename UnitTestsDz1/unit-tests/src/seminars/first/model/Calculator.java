package seminars.first.model;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+' -> result = firstOperand + secondOperand;
            case '-' -> result = firstOperand - secondOperand;
            case '*' -> result = firstOperand * secondOperand;
            case '/' -> {
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    throw new ArithmeticException("Делить на ноль нельзя");
                }
            }
            case '^' -> result = (int) Math.pow(firstOperand, secondOperand);
            default -> throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        if (number < 0) {
            throw new ArithmeticException("Извлечение квадратного корня из отрицательного рационального числа не определено");
        }

        return Math.sqrt(number);
    }

    /**
     * Метод вычисления суммы заказа со скидкой
     *
     * @param orderCount    сумма покупки
     * @param discountOrder размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */

    public static double calculateDiscount(double orderCount, double discountOrder) {
        if (discountOrder == 0) {
            return orderCount;  // Если скидки нет, возвращаем полную сумму заказа
        } else if (orderCount < 0 || discountOrder < 0 || 50.0 < discountOrder) {
            throw new ArithmeticException("Сумма заказа и размер скидки не могут быть меньше ноля, запрет на скидки более 50%");
        }
        return orderCount - (orderCount * (discountOrder / 100.0));
    }
}

