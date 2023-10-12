package seminars.fourth.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WebServiceTest {
    public HttpClient httpClient;
    public WebService webService;

    /**
     * Тест проверяет корректность получения тестовой страницы
     */

    @Test
    public void testGetPage() {
        httpClient = mock(HttpClient.class);
        webService = new WebService(httpClient);
        String url = "https://goole.com/php?";
        String testPage = "MainPage";
        when(httpClient.get(url)).thenReturn(testPage);
        assertEquals(testPage, webService.getUrl(url));
        verify(httpClient).get(url);
        verify(httpClient, times(1)).get(url);
    }
}