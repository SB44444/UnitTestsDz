package seminars.fourth.message;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/** 4.5. Тест с использованием Mockito для сервиса отправки сообщений.
      Проверяет правильность работы класса NotificationService,
      который использует MessageService для отправки уведомлений.
    */

class NotificationServiceTest {
    @Test
    void testMessageService(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        String message = "Привет!";
        String recipient= "Анна";
        notificationService.sendNotification(message, recipient);
        verify(messageService).sendMessage(message, recipient);
        verify(messageService, times(1)).sendMessage(message, recipient);

    }

}
