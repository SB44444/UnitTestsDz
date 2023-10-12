package seminars.fourth.database;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DataProcessorTest {
    /** Тест с использованием Mockito для сервиса отправки сообщений.
     Проверяет правильность получения запроса,
     добавление данных в список, проверяет его размер и количество вызовов
     */
    @Test
    public void testProcessData() {

        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        String sql = "SELECT * FROM fakeData";
        List<String> fakeData = new ArrayList<>();
        fakeData.add("Data1");
        fakeData.add("Data2");
        fakeData.add("Data3");

        when(database.query(sql)).thenReturn(fakeData);
        List<String> fakeList = dataProcessor.processData(sql);
        assertEquals(3, fakeList.size());
        verify(database).query(sql);
        verify(database, times(1)).query(sql);
    }
}