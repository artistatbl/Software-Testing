package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class FineTest {

    @Test
    void calculateFine() {
        Fine fine = new Fine();
        LocalDate dueDate = LocalDate.of(2023, 1, 1);
        LocalDate returnDate = LocalDate.of(2023, 1, 10);
        double expectedFineAmount = 5.0; // Expected fine based on your business logic
        assertEquals(expectedFineAmount, fine.calculateFine(dueDate, returnDate), "Calculated fine should match the expected amount.");
        System.out.println(fine.calculateFine(dueDate, returnDate));
    }

    @Test
    void getFineId() {
        Fine fine = new Fine();
        fine.setFineId(1);
        assertEquals(1, fine.getFineId(), "Getter for FineId should retrieve the correct value.");
        System.out.println("Fine ID: "+ fine.getFineId());
    }

    @Test
    void setFineId() {
        Fine fine = new Fine();
        fine.setFineId(1);
        assertEquals(1, fine.getFineId(), "Setter for FineId should set the correct value.");
        System.out.println("Fine ID: "+ fine.getFineId());

    }

    @Test
    void getMemberId() {
        Fine fine = new Fine();
        fine.setMemberId(2);
        assertEquals(2, fine.getMemberId(), "Getter for MemberId should retrieve the correct value.");
    }

    @Test
    void setMemberId() {
        Fine fine = new Fine();
        fine.setMemberId(2);
        assertEquals(2, fine.getMemberId(), "Setter for MemberId should set the correct value.");
    }

    @Test
    void getAmount() {
        Fine fine = new Fine();
        fine.setAmount(5.0);
        assertEquals(5.0, fine.getAmount(), "Getter for Amount should retrieve the correct value.");
    }

    @Test
    void setAmount() {
        Fine fine = new Fine();
        fine.setAmount(5.0);
        assertEquals(5.0, fine.getAmount(), "Setter for Amount should set the correct value.");
    }

    @Test
    void getReason() {
        Fine fine = new Fine();
        fine.setReason("Late return");
        assertEquals("Late return", fine.getReason(), "Getter for Reason should retrieve the correct value.");
    }

    @Test
    void setReason() {
        Fine fine = new Fine();
        fine.setReason("Late return");
        assertEquals("Late return", fine.getReason(), "Setter for Reason should set the correct value.");
    }

    @Test
    void getDateIssued() {
        Fine fine = new Fine();
        LocalDate dateIssued = LocalDate.now();
        fine.setDateIssued(dateIssued);
        assertEquals(dateIssued, fine.getDateIssued(), "Getter for DateIssued should retrieve the correct value.");
    }

    @Test
    void setDateIssued() {
        Fine fine = new Fine();
        LocalDate dateIssued = LocalDate.now();
        fine.setDateIssued(dateIssued);
        assertEquals(dateIssued, fine.getDateIssued(), "Setter for DateIssued should set the correct value.");
        System.out.println("Date Issued: " + fine.getDateIssued());
    }

    @Test
    void getDatePaid() {
        Fine fine = new Fine();
        LocalDate datePaid = LocalDate.now();
        fine.setDatePaid(datePaid);
        assertEquals(datePaid, fine.getDatePaid(), "Getter for DatePaid should retrieve the correct value.");
    }

    @Test
    void setDatePaid() {
        Fine fine = new Fine();
        LocalDate datePaid = LocalDate.now();
        fine.setDatePaid(datePaid);
        assertEquals(datePaid, fine.getDatePaid(), "Setter for DatePaid should set the correct value.");
    }
}
