package daos;

import models.Book;
import models.Member;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOTest {
    private static MemberDAO memberDAO;
    private Member testMember;

   @BeforeAll
   static void init() {
    memberDAO = new MemberDAO();
   }
//
//    @BeforeEach
//    void setUp() {
//        // Create a test member
//        testMember = new Member("TestFirstName", "TestLastName", "aasjfa@esdxample.com", "1234567890", "123 Test Street", "Apt 1", "TestCity", "TestCounty", "12345", LocalDate.now());
//        assertTrue(memberDAO.addMember(testMember), "Member should be added successfully");
//    }

    @Test
    void testAddMember() {
        Member newMember = new Member("", "", "adasdaasdadasdS", "dfgfdgfdg", "", "Apt 2", "NewCity", "NewCounty", "54321", LocalDate.now());
        assertTrue(memberDAO.addMember(newMember), "New member should be added successfully");

        // Optionally, verify that the new member was added to the database
    }

    @Test
    void testDeleteMember() {
        assertTrue(memberDAO.deleteMember(testMember.getMemberID()), "Member should be deleted successfully");

        // Verify that the member is no longer in the database
        Member deletedMember = memberDAO.getMember(testMember.getMemberID());
        assertNull(deletedMember, "Deleted member should not be retrievable");
    }
    @Test
    void testUpdateMember() {
        // Ensure the member with memberID 1 exists in the database
        // If necessary, add the member first, or use an existing member
        Member existingMember = memberDAO.getMember(1);
        assertNotNull(existingMember, "Member with memberID 1 should exist for the test");

        // Update some information of the existing member
        existingMember.setLastName("jeanaa");
        assertTrue(memberDAO.updateMember(existingMember), "Member should be updated successfully");

        // Verify that the member's details have been updated in the database
        Member updatedMember = memberDAO.getMember(1);
        assertNotNull(updatedMember, "Updated member should not be null");
        assertEquals("", updatedMember.getLastName(), "Member's last name should be updated");
        //System.out.println();
    }
    @Test
    void testRetrieveMember() {
        // Attempt to retrieve the member using the ID
        Member retrievedMember = memberDAO.getMember(1);
        // Assertions to verify the retrieved member matches the one we added
        assertNotNull(retrievedMember, "Retrieved member should not be null");
        assertEquals(1, retrievedMember.getMemberID(), "Member IDs should match");
        //assertEquals(testMember.getFirstName(), retrievedMember.getFirstName(), "First names should match");
        //assertEquals(testMember.getLastName(), retrievedMember.getLastName(), "Last names should match");
        System.out.println("MemberID:" +  retrievedMember.getMemberID() + " FirstName:" + retrievedMember.getFirstName() + " LastName" + retrievedMember.getLastName());
        // ... additional assertions as needed for other fields
    }
    @Test
    void testGettingAllMembersFromDAO(){
        List<Member> members = memberDAO.getAllMembers();
        assertFalse(members.isEmpty(), "The member list should not be empty");
       


        members.forEach(member ->
                System.out.println("MemberID: " + member.getMemberID() + ", Name: " +
                        member.getFirstName() + " " + member.getLastName()));
    }




    @Test
    void testAddMemberWithInvalidEmail() {
        MemberDAO memberDAO = new MemberDAO();
        Member invalidMember = new Member("John", "Doe", "invalidemail", "1234567890", "123 Main St", "", "Anytown", "Anystate", "12345", LocalDate.now());

        assertFalse(memberDAO.addMember(invalidMember), "Member with invalid email should not be added");
    }
    @Test
    void testAddMemberWithValidEmail() {
        MemberDAO memberDAO = new MemberDAO();
        Member validMember = new Member("Jane", "Doe", "jane22.doe@example.com", "1234567890", "123 Main St", "", "Anytown", "Anystate", "12345", LocalDate.now());

        assertTrue(memberDAO.addMember(validMember), "Member with valid email should be added");
        // Clean up (assuming deleteMember is a working method to remove the test member)
        //memberDAO.deleteMember(21);
    }




//
//    @AfterEach
//    void tearDown() {
//        // Attempt to delete the test member to clean up the database
//        memberDAO.deleteMember(testMember.getMemberID());
//    }
}
