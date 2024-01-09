package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class LoanTest {
    private Loan loan;

    @BeforeEach
    void setUp() {
        loan = new Loan();
    }

    @AfterEach
    void tearDown() {
        // Clean-up code if necessary
    }

    @Test
    void getLoanId() {
        loan.setLoanId(5);
        assertEquals(5, loan.getLoanId());
    }

    @Test
    void setLoanId() {
        loan.setLoanId(5);
        assertEquals(5, loan.getLoanId());
    }

    @Test
    void getBookId() {
        loan.setBookId(5);
        assertEquals(5, loan.getBookId());
    }

    @Test
    void setBookId() {
        loan.setBookId(5);
        assertEquals(5, loan.getBookId());
    }

    @Test
    void getMemberId() {
        loan.setMemberId(5);
        assertEquals(5, loan.getMemberId());
    }

    @Test
    void setMemberId() {
        loan.setMemberId(5);
        assertEquals(5, loan.getMemberId());
    }

    @Test
    void getLoanDate() {
        LocalDate loanDate = LocalDate.of(2023, 1, 1);
        loan.setLoanDate(loanDate);
        assertEquals(loanDate, loan.getLoanDate());
    }

    @Test
    void setLoanDate() {
        LocalDate loanDate = LocalDate.of(2023, 1, 1);
        loan.setLoanDate(loanDate);
        assertEquals(loanDate, loan.getLoanDate());
    }

    @Test
    void getDueDate() {
        LocalDate dueDate = LocalDate.of(2023, 2, 1);
        loan.setDueDate(dueDate);
        assertEquals(dueDate, loan.getDueDate());
    }

    @Test
    void setDueDate() {
        LocalDate dueDate = LocalDate.of(2023, 2, 1);
        loan.setDueDate(dueDate);
        assertEquals(dueDate, loan.getDueDate());
    }

    @Test
    void getReturnDate() {
        LocalDate returnDate = LocalDate.of(2023, 3, 1);
        loan.setReturnDate(returnDate);
        assertEquals(returnDate, loan.getReturnDate());
    }

    @Test
    void setReturnDate() {
        LocalDate returnDate = LocalDate.of(2023, 3, 1);
        loan.setReturnDate(returnDate);
        assertEquals(returnDate, loan.getReturnDate());
    }

    @Test
    void getFine() {
        Fine fine = new Fine(); // Assuming Fine is another class related to Loan
        loan.setFine(fine);
        assertEquals(fine, loan.getFine());
    }

    @Test
    void setFine() {
        Fine fine = new Fine(); // Assuming Fine is another class related to Loan
        loan.setFine(fine);
        assertEquals(fine, loan.getFine());
    }

    @Test
    void testToString() {
        loan.setLoanId(5);
        loan.setBookId(5);
        loan.setMemberId(5);
        LocalDate loanDate = LocalDate.of(2023, 1, 1);
        LocalDate dueDate = LocalDate.of(2023, 2, 1);
        LocalDate returnDate = LocalDate.of(2023, 3, 1);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setReturnDate(returnDate);

        String expectedString = "Loan{" +
                "loanId=5, bookId=5, memberId=5, loanDate=" + loanDate +
                ", dueDate=" + dueDate + ", returnDate=" + returnDate + '}';
        assertEquals(expectedString, loan.toString());
        System.out.println(loan);
    }
}
