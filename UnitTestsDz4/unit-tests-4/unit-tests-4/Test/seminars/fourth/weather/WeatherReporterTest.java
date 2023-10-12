package seminars.fourth.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherReporterTest {
    @Test
    void testReportNest() {
        WeatherService testWeatherService = mock(WeatherService.class);
        WeatherReporter reporter = new WeatherReporter(testWeatherService);
        when(testWeatherService.getCurrentTemperature()).thenReturn(15);

        String res = reporter.generateReport();
        // Assert
        assertEquals("Текущая температура: 15 градусов.", res);
        verify(testWeatherService, times(1)).getCurrentTemperature();
    }

}