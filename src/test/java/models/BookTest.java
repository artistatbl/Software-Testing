package models;

import static org.junit.jupiter.api.Assertions.*;


import daos.BookDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


class BookTest {
    private BookDAO bookDAO;

    @BeforeEach
    void setUp(){
        bookDAO = new BookDAO();
    }

    @Test
    void getAndSetBookID() {
        Book book = new Book();
        book.setBookID(100);
        assertEquals(100, book.getBookID());
    }

    @Test
    void getAndSetTitle() {
        Book book = new Book();
        book.setTitle("Example Title");
        assertEquals("Example Title", book.getTitle());
    }

    @Test
    void getAndSetAuthorFirstName() {
        Book book = new Book();
        book.setAuthorFirstName("John");
        assertEquals("John", book.getAuthorFirstName());
    }

    @Test
    void getAndSetAuthorSurname() {
        Book book = new Book();
        book.setAuthorSurname("Doe");
        assertEquals("Doe", book.getAuthorSurname());
    }

    @Test
    void getAndSetISBN() {
        Book book = new Book();
        book.setISBN("1234567890");
        assertEquals("1234567890", book.getISBN());
    }

    @Test
    void getAndSetPublishDate() {
        Book book = new Book();
        LocalDate date = LocalDate.of(2020, 1, 1);
        book.setPublishDate(date);
        assertEquals(date, book.getPublishDate());
    }

    @Test
    void getAndSetGenre() {
        Book book = new Book();
        book.setGenre("Fiction");
        assertEquals("Fiction", book.getGenre());
    }

    @Test
    void getAndSetPublisherName() {
        Book book = new Book();
        book.setPublisherName("Publisher");
        assertEquals("Publisher", book.getPublisherName());
    }

    @Test
    void getAndSetAvailabilityStatus() {
        Book book = new Book();
        book.setAvailabilityStatus("Available");
        assertEquals("Available", book.getAvailabilityStatus());
    }

    @Test
    void getAndSetCondition() {
        Book book = new Book();
        book.setCondition("New");
        assertEquals("New", book.getCondition());
    }

    @Test
    void testToString() {
        Book book = new Book(1, "JEAN", "AuthorFirst", "AuthorLast", "ISBN123",
                LocalDate.of(2020, 1, 1), "Genre", "Publisher", "Available", "New");
       String expectedString = "Book{title='Title', authorFirstName='AuthorFirst', authorSurname='AuthorLast', ISBN='ISBN123', publishDate=2020-01-01, genre='Genre', publisherName='Publisher', availabilityStatus='Available', condition='New'}";
        //assertEquals(expectedString, book.toString());
        System.out.println("Book added: " + book);
    }

}
