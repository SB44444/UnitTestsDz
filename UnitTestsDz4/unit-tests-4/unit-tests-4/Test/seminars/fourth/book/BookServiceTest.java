package seminars.fourth.book;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

	/** Тест с использованием Mockito.
     Проверяет правильность поиска книги по id и количество вызовов метода
     */
    @Test
    void findByIdTest(){

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book = new Book("1", "Book1", "Author1");
        when(bookRepository.findById("1")).thenReturn(book);
        assertEquals(book, bookService.findBookById("1"));
        verify(bookRepository).findById("1");

    }
    /** Тест с использованием Mockito.
     Проверяет правильность добавления данных в список, проверяет его размер и количество вызовов
     */
    @Test
    void findBookByIdTest() {

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> books;
        books = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2") );
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> bookList = bookService.findAllBooks();
        assertEquals(2, bookList.size());
        verify(bookRepository).findAll();
        verify(bookRepository, times(1)).findAll();
    }

}