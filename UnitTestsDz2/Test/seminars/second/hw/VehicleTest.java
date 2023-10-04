package seminars.second.hw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    private Car car;

    @BeforeEach  // на каждый тест создаётся свой экземпляр
    public void setUpCar() {
        car = new Car("Kia", "Rio", 2020);
    }

    /**
     * Проверка того, что экземпляр объекта Car также является экземпляром транспортного средства;
     */
    @Test
    void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);
    }

    /**
     * Проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    void testCarWith4Wheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * Поверка того, объект Car развивает скорость 60 в режиме тестового вождения
     */
    @Test
    void testTestDriveCar() {
        car.testDrive();
        int testDriveSpeed = car.getSpeed();
        assertEquals(60, testDriveSpeed);
    }

    /**
     * Проверка, что в режиме парковки машина останавливается (speed = 0)
     */
    @Test
    void testParkCar() {
        car.park();
        int testParkSpeed = car.getSpeed();
        assertEquals(0, testParkSpeed);
    }
    // Увеличиваем процент покрытия кода

    /**
     * Проверка корректности производителя
     */
    @Test
    void testCarCompany() {
        assertThat(car.getCompany()).isEqualTo("Kia");

    }

    /**
     * Проверка корректности модели
     */
    @Test
    void testCarModel() {
        assertThat(car.getModel()).isEqualTo("Rio");

    }

    /**
     * Проверка корректности года выпуска
     */
    @Test
    void testCarYearRelease() {
        assertThat(car.getYearRelease()).isEqualTo(2020);

    }

    private Motorcycle motorcycle;

    @BeforeEach  // на каждый тест создаётся свой экземпляр
    public void setUpMoto() {
        motorcycle = new Motorcycle("Yamaha", "Thunder Ace", 2020);
    }

    /**
     * Проверка того, что экземпляр объекта Motorcycle также является экземпляром транспортного средства;
     */
    @Test
    void testMotorcycleIsInstanceOfVehicle() {
        assertTrue(motorcycle instanceof Vehicle);
    }

    /**
     * Проверка того, объект Motorcycle создается с 2-мя колесами
     */
    @Test
    void testMotorcycleWith2Wheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);

    }

    /**
     * Поверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения
     */
    @Test
    void testTestDriveMotorcycle() {
        motorcycle.testDrive();
        int testDriveSpeed = motorcycle.getSpeed();
        assertEquals(75, testDriveSpeed);
    }

    /**
     * Проверка, что в режиме парковки объект Motorcycle останавливается (speed = 0)
     */
    @Test
    void testParkMotorcycle() {
        motorcycle.park();
        int testParkSpeed = motorcycle.getSpeed();
        assertEquals(0, testParkSpeed);
    }

    /**
     * Проверка корректности производителя
     */
    @Test
    void testMotorcycleCompany() {
        assertThat(motorcycle.getCompany()).isEqualTo("Yamaha");

    }

    /**
     * Проверка корректности модели
     */
    @Test
    void testMotorcycleModel() {
        assertThat(motorcycle.getModel()).isEqualTo("Thunder Ace");

    }

    /**
     * Проверка корректности года выпуска
     */
    @Test
    void testMotorcycleYearRelease() {
        assertThat(motorcycle.getYearRelease()).isEqualTo(2020);

    }

}