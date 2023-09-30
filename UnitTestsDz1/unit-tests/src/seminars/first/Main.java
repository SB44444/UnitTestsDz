package seminars.first;

import seminars.first.model.Hero;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Main {


    public static void main(String[] args) {
        assertConditionA();

        assertConditionB(-1);

        System.out.println(sum(2_147_483_647, 2));

        happyNY();

        expectedValue();

        checkingShoppingCart();

        String[] colors = {"aqua", "orange", "green", "violet", "yellow", "blue", "gold"};
        testingJavaCollectionsAssertJ(colors);

        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);
        checkingHero(emmett);
    }

    /**
     * 1) Нужно найти и исправить ошибку в условиях assert
     */
    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    /**
     * 2) Нужно найти и исправить ошибку в условиях assert
     */
    public static void assertConditionB(int x) {
        //int x = -1;
        assert x < 0;
        System.out.println(x + " отрицательное число");
    }

    /**
     * 3) Нужно, используя данную функцию, попробовать сложить два следующих числа
     * 2_147_483_647 и 1, написать assert если нужно
     * (//habr.com/ru/company/pvs-studio/blog/306748/)
     *
     * @param a первое число
     * @param b второе число
     * @return сумму переданных чисел
     * @apiNote assert boolean_выражение : сообщение_об_ошибке;
     */
    public static int sum(int a, int b) {
        assert 2147483647 - a >= b;
        return a + b;
    }

    /**
     * 4) Нужно найти и исправить ошибку в условиях assert
     * windows fail -
     * //habr.com/ru/company/pvs-studio/blog/698404/
     */
    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());

        // Получили строку currentDateTime в формате "09/12/2022 20:20:04"

        assert currentDateTime.equals("01/01/2023 00:00:00") : "С новым годом!";
        System.out.println("Еще 2022 год :(");
    }

    /**
     * 5) Утверждение предупреждает об ошибке, нужно исправить код, чтобы утверждение не выбрасывало ошибку
     */
    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        productCategories.add("drink");

        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");

        for (String product : products) {
            switch (product) {
                case "apple" -> System.out.println("category: " + productCategories.get(0));
                case "tomato" -> System.out.println("category: " + productCategories.get(1));
                case "bread" -> System.out.println("category: " + productCategories.get(2));
                case "water" -> System.out.println("category: " + productCategories.get(3));
                default -> {
                    assert false : "Unknown category for the product " + product;
                }
            }
        }
    }

    /**
     * 6) Найдите ошибку
     */
    public static void expectedValue() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }

    /**
     * 7) Нужно передать в метод массив, который соответствует условиям в утверждении
     *
     * @param colors массив с цветами
     */
    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }

    /**
     * 8) Удовлетворить всем условиям: <p>
     * 1. Проверить, что герой создался с именем Emmett<p>
     * 2. Проверить, что значение прочности брони героя равно 50<p>
     * 3. Проверить, что у героя оружие типа sword<p>
     * 4. Проверить содержимое инвентаря героя (размер 3, содержимое "Bow", "Axe", "Gold", порядок не важен)<p>
     * 5. Проверить, что герой это человек (свойство isHuman)<p>
     */
    public static void checkingHero(Hero emmett) {
        assertThat(emmett.getName()).isEqualTo("Emmett").hasSize(6);
        assertThat(emmett.getArmorStrength()).isEqualTo(50);
        assertEquals(emmett.getArmorStrength(), 50);
        assertThat(emmett.getWeapon()).isEqualTo("sword");
        assertThat(emmett.getBag()).isNotEmpty().hasSize(3).contains("Bow", "Axe", "Gold");
        assertThat(emmett.isHuman()).isEqualTo(true);
        assertTrue(emmett.isHuman());

    }

}