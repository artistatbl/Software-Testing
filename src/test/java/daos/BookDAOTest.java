package daos;

import models.Book;
import models.Loan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {
    private static BookDAO bookDAO;
    private static LoanDAO loanDAO;


    private Loan testLoan;
    private Book testBook;


    @BeforeAll
    static void init(){

        bookDAO =  new BookDAO(); // use the test database
        loanDAO = new LoanDAO(); //
    }
    @BeforeEach
    void setUp() {
        // Create a test book to use in the tests
        testBook = new Book("Test Title", "Test Author First Name", "Test Author Surname", "1234567890123", LocalDate.now(), "Test Genre", "Test Publisher", "Available", "New");
        assertTrue(bookDAO.addBook(testBook), "Book should be added successfully");

        // Create a test loan
//        testLoan = new Loan(1, testBook.getBookID(), LocalDate.now(), LocalDate.now().plusDays(14));
//        assertTrue(loanDAO.borrowBook(testLoan), "Loan should be created successfully");
    }




    @Test
    void addBook() {
        // Create a test book to use in the tests


        testBook = new Book("Test Title", "Test First Name", "Test Surname", "123456789", LocalDate.now(), "Test Genre", "Test Publisher", "Available", "New");
        assertTrue(bookDAO.addBook(testBook), "Book should be added successfully");

    }




    @Test
    void updateBookAvailabilityStatus() {

        // Step 2: Update the availability status of the test book
        String newStatus = "Checked Out";
        assertTrue(bookDAO.updateBookAvailabilityStatus(testBook.getBookID(), newStatus), "Availability status should be updated successfully");

        // Step 3: Retrieve the updated book
        Book updatedBook = bookDAO.getBook(1);
        assertNotNull(updatedBook, "Updated book should not be null");

        // Step 4: Assert that the availability status has been updated
        assertEquals(newStatus, updatedBook.getAvailabilityStatus(), "Availability status should match the updated value");

        // Step 5: Clean up - delete the test book
        assertTrue(bookDAO.deleteBook(testBook.getBookID()), "Book should be deleted successfully");
    }


    @Test
    void getBook() {
        //Retrieve the book by ID and verify it's the same as the test book
        Book existingBook = bookDAO.getBook(1);

       // Book retrievedBook = bookDAO.getBook(testBook.getBookID());
        assertNotNull(existingBook, "Retrieved book should not be null");
       // assertEquals(testBook.getTitle(), existingBook.getTitle(), "Titles should match");
        // Add more assertions for other fields
    }
    @Test
    void testReturnBookWithBookId() {

        // Verify that the correct book has been returned
        Book retrievedBook = bookDAO.getBook(1);
        assertNotNull(retrievedBook, "Retrieved book should not be null after return");
        assertEquals("On Loan", retrievedBook.getAvailabilityStatus(), "Book's availability status should be 'Available' after being returned");
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        assertFalse(books.isEmpty(), "Book list should not be empty");
        System.out.print("Book Available: " + books);
        // Optionally, check for the presence of the test book in the list
        // ...
    }


    @Test
    void updateBook() {
        // Update some information of the test book
        testBook.setTitle("Updated Title");
        assertTrue(bookDAO.updateBook(testBook), "Book should be updated successfully");

        // Retrieve the book again and verify the updates
        Book updatedBook = bookDAO.getBook(1);
        assertNotNull(updatedBook, "Updated book should not be null");
        assertEquals("Updated Title", updatedBook.getTitle(), "Updated title should match");
        System.out.println("Update Book:" + updatedBook);
        // Add more assertions for other fields if necessary
    }


    @Test
    void deleteBook() {
        // Delete the test book
        assertTrue(bookDAO.deleteBook(testBook.getBookID()), "Book should be deleted successfully");

        // Try to retrieve the deleted book and verify that it's null
        Book deletedBook = bookDAO.getBook(testBook.getBookID());
        assertNull(deletedBook, "Deleted book should not be retrievable");
        System.out.println("Book Delete: "+ testBook);
    }

    @Test
    void addBook_MissingTitle_ShouldFail() {
        Book bookWithoutTitle = new Book("", "Valid Author", "Valid Surname", "1234567890123", LocalDate.now(), "Valid Genre", "Valid Publisher", "Available", "New");
        assertFalse(bookDAO.addBook(bookWithoutTitle), "Adding a book without title should fail.");
    }

    @Test
    void addBook_MissingAuthor_ShouldFail() {
        Book bookWithoutAuthor = new Book("Valid Title", "", "Valid Surname", "1234567890123", LocalDate.now(), "Valid Genre", "Valid Publisher", "Available", "New");
        assertFalse(bookDAO.addBook(bookWithoutAuthor), "Adding a book without an author should fail.");
    }
    @Test
    void addBook_ShouldFailWithoutGenre() {
        Book bookWithoutGenre = new Book("Title", "AuthorFirstName", "AuthorLastName", "ISBN", LocalDate.now(), "", "Publisher", "Available", "New");
        assertFalse(bookDAO.addBook(bookWithoutGenre), "Adding a book without a genre should return false.");
    }
    @Test
    void addBook_MissingISBN_ShouldFail() {
        Book bookWithoutISBN = new Book("Valid Title", "Valid Author", "Valid Surname", "", LocalDate.now(), "Valid Genre", "Valid Publisher", "Available", "New");
        assertFalse(bookDAO.addBook(bookWithoutISBN), "Adding a book without ISBN should fail.");
    }
    @Test
    void addBook_MissingDate_ShouldFail(){
        Book bookWithoutDate = new Book("Valid Title", "Valid Author", "Valid Surname", "111111", null, "Valid Genre", "Valid Publisher", "Available", "New");
        assertFalse(bookDAO.addBook(bookWithoutDate), "Adding a book without ISBN should fail.");

    }
    @Test
    void CreateTestLoan(){
        testLoan = new Loan(1, 105, LocalDate.now(), LocalDate.now().plusDays(14));
        assertTrue(loanDAO.borrowBook(testLoan), "Loan should be created successfully");

    }

    @Test
    void testBorrowBook() {
        // Check if the book's availability status is updated correctly
        Book borrowedBook = bookDAO.getBook(2);
        assertEquals("On Loan", borrowedBook.getAvailabilityStatus(), "Book's availability status should be updated to 'On Loan' after borrowing");
    }

    @Test
    void testReturnBook() {
        assertTrue(loanDAO.returnBook(1), "Book return should be successful");

        // Check if the book's availability status is updated correctly after return
        Book returnedBook = bookDAO.getBook(4);
        assertEquals("Available", returnedBook.getAvailabilityStatus(), "Book's availability status should be 'Available' after returning");
    }






//
//    @AfterEach
//    void tearDown() {
//        // Attempt to delete the test book to clean up the database after each test
//        bookDAO.deleteBook(testBook.getBookID());
//    }



}