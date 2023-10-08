package seminars.third.tdd;
import seminars.third.tdd.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class UserRepositoryTest {
    private UserRepository userRepository;
    private List<User> data;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        data = new ArrayList<>();

    }
    @Test   // Проверка, что размер списка соответствует количеству пользователей
    void testAddUser() {
        User user1 = new User("Ted", "AAA", true, true);
        User user2 = new User("Don", "BBB", false, true);
        User user3 = new User("Fox", "FFF", false, false);

        userRepository.addUser(user1);   //   Проверка, что пользователи добавились
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        data = userRepository.data;
        assertEquals(data.size(), 3); // Проверка, что размер списка соответствует количеству пользователей
        assertTrue(data.contains(user1));   // Проверка, что в списке те пользователи, которых добавили
        assertTrue(data.contains(user2));
        assertTrue(data.contains(user3));
    }

    @Test
    void testFindByName(){
        User user3 = new User("Fox", "FFF", false, false);
        userRepository.addUser(user3);
        assertTrue(userRepository.findByName("Fox")); // Проверка, поиска пользователя по имени ДА/НЕТ
        assertFalse(userRepository.findByName("123"));
    }
}