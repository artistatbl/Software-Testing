package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class MemberTest {

    @Test
    void getMemberID() {
        Member member = new Member();
        member.setMemberID(1);
        assertEquals(1, member.getMemberID());
    }

    @Test
    void setMemberID() {
        Member member = new Member();
        member.setMemberID(1);
        assertEquals(1, member.getMemberID());
    }

    @Test
    void getFirstName() {
        Member member = new Member();
        member.setFirstName("John");
        assertEquals("John", member.getFirstName());
    }

    @Test
    void setFirstName() {
        Member member = new Member();
        member.setFirstName("John");
        assertEquals("John", member.getFirstName());
    }

    @Test
    void getLastName() {
        Member member = new Member();
        member.setLastName("Doe");
        assertEquals("Doe", member.getLastName());
    }

    @Test
    void setLastName() {
        Member member = new Member();
        member.setLastName("Doe");
        assertEquals("Doe", member.getLastName());
    }

    @Test
    void getEmail() {
        Member member = new Member();
        member.setEmail("john@example.com");
        assertEquals("john@example.com", member.getEmail());
    }

    @Test
    void setEmail() {
        Member member = new Member();
        member.setEmail("john@example.com");
        assertEquals("john@example.com", member.getEmail());
    }

    @Test
    void getPhone() {
        Member member = new Member();
        member.setPhone("1234567890");
        assertEquals("1234567890", member.getPhone());
    }

    @Test
    void setPhone() {
        Member member = new Member();
        member.setPhone("1234567890");
        assertEquals("1234567890", member.getPhone());
    }

    @Test
    void getAddressLine1() {
        Member member = new Member();
        member.setAddressLine1("123 Main St");
        assertEquals("123 Main St", member.getAddressLine1());
    }

    @Test
    void setAddressLine1() {
        Member member = new Member();
        member.setAddressLine1("123 Main St");
        assertEquals("123 Main St", member.getAddressLine1());
    }

    @Test
    void getAddressLine2() {
        Member member = new Member();
        member.setAddressLine2("Apartment 4");
        assertEquals("Apartment 4", member.getAddressLine2());
    }

    @Test
    void setAddressLine2() {
        Member member = new Member();
        member.setAddressLine2("Apartment 4");
        assertEquals("Apartment 4", member.getAddressLine2());
    }

    @Test
    void getTownOrCity() {
        Member member = new Member();
        member.setTownOrCity("Anytown");
        assertEquals("Anytown", member.getTownOrCity());
    }

    @Test
    void setTownOrCity() {
        Member member = new Member();
        member.setTownOrCity("Anytown");
        assertEquals("Anytown", member.getTownOrCity());
    }

    @Test
    void getCounty() {
        Member member = new Member();
        member.setCounty("AnyCounty");
        assertEquals("AnyCounty", member.getCounty());
    }

    @Test
    void setCounty() {
        Member member = new Member();
        member.setCounty("AnyCounty");
        assertEquals("AnyCounty", member.getCounty());
    }

    @Test
    void getPostCode() {
        Member member = new Member();
        member.setPostCode("12345");
        assertEquals("12345", member.getPostCode());
    }

    @Test
    void setPostCode() {
        Member member = new Member();
        member.setPostCode("12345");
        assertEquals("12345", member.getPostCode());
    }

    @Test
    void getDateRegistered() {
        LocalDate testDate = LocalDate.of(2023, 1, 1);
        Member member = new Member();
        member.setDateRegistered(testDate);
        assertEquals(testDate, member.getDateRegistered());
    }

    @Test
    void setDateRegistered() {
        LocalDate testDate = LocalDate.of(2023, 1, 1);
        Member member = new Member();
        member.setDateRegistered(testDate);
        assertEquals(testDate, member.getDateRegistered());
    }
}
