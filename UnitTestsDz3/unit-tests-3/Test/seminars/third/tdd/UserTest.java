package seminars.third.tdd;

import seminars.third.tdd.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp(){
        user1 = new User("Ted", "AAA", true, true);
        user2 = new User("Don", "BBB", false, true);
        user3 = new User("Fox", "FFF", false, false);
    }

    @Test
    void testUser1(){
        assertEquals(user1.getName(), "Ted");        // Корректное имя OK
        assertEquals(user1.getPassword(), "AAA");    // Корректный пароль OK
        assertTrue(user1.isAdmin);                         // Администратор OK
        assertTrue(user1.isAuthenticate);                  // Зарегистрирован OK
    }
    @Test
    void testUser2(){
        assertEquals(user2.getName(), "Don");       // Корректное имя OK
        assertEquals(user2.getPassword(), "BBB");   // Корректный пароль OK
        assertFalse(user2.isAdmin);                       // Администратор НЕТ
        assertTrue(user2.isAuthenticate);                 // Зарегистрирован OK
    }

    @Test
    void testAuthenticate(){
        assertTrue(user1.authenticate("Ted", "AAA")); // Вход администратора OK
        assertFalse(user1.authenticate("UUU", "AAA")); // Вход с ошибочным именем Отказ
        assertFalse(user1.authenticate("Ted", "123")); // Вход с ошибочным паролем Отказ
        assertTrue(user2.authenticate("Don", "BBB"));  // Вход не администратора OK
        assertFalse(user3.authenticate("Fox", "AAA")); // Вход незарегистрированного пользователя Отказ
    }

    @Test
    void testSetName() {                             // Установлено корректное имя OK
        user1.setName("Ted2");
        assertEquals(user1.getName(), "Ted2");
    }

    @Test
    void testSetPassword() {                         // Установлен корректный пароль OK
        user1.setPassword("NNN");
        assertEquals(user1.getPassword(), "NNN");
    }

    @Test
    void testSetIsAdmin() {                       // Установлен статус администратора OK
        user2.setIsAdmin(true);
        assertTrue(user2.isAdmin);
    }

    @Test
    void testSetIsAuthenticate() {    // Установлен статус зарегистрированного пользователя OK
        user3.setAuthenticate(true);
        assertTrue(user3.isAuthenticate);
    }

    @Test
    void testIsAdmin() {                       // Cтатус администратора OK
        assertTrue(user1.isAdmin);
    }

    @Test
    void testIsAuthenticate() {                       // Cтатус зарегистрированного пользователя OK
        assertTrue(user2.isAuthenticate);
    }
}