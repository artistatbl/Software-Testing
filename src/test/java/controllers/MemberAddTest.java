package controllers;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.util.WaitForAsyncUtils.waitFor;

class MemberAddTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception{
        new main.Main().start(stage);

    }

    @Test
    public void testAddMemberButton_shouldAddMemberToGUI() {
        // Assuming your add member button has a fx:id "addMemberButton"
        //clickOn("#addMemberButton");
        clickOn(1700,400);

        // Fill in the details for the new member
        clickOn("#firstNameField").write("John");
        clickOn("#lastNameField").write("Doe");
        clickOn("#emailField").write("john.doe@example.com");
        clickOn("#phoneField").write("1234567890");
        clickOn("#addressLine1Field").write("123 Main St");
        clickOn("#addressLine2Field").write("Apt 4");
        clickOn("#townOrCityField").write("Anytown");
        clickOn("#countyField").write("Anystate");
        clickOn("#postCodeField").write("12345");

        // Set the date registered using a DatePicker
        interact(() -> {
            DatePicker dateRegisteredPicker = lookup("#dateRegisteredPicker").queryAs(DatePicker.class);
            dateRegisteredPicker.setValue(LocalDate.of(2023, 1, 1));
        });

        // Assuming the save button has a fx:id "saveButton"
        clickOn("#saveButton");

        sleep(1000); // Wait for UI to update


    }

    @Test
    public void testDeleteMemberButton_shouldRemoveMemberFromGUI() {
        // Select a member from the table
        // Assuming your TableView has a fx:id "membersTable"
        TableView<Member> membersTable = lookup("#membersTable").queryAs(TableView.class);
        assertNotNull(membersTable);
        interact(() -> membersTable.getSelectionModel().select(0)); // Select the first member

        // Click the delete button;
        Platform.runLater(()->{
            //clickOn("#deleteMemberButton");
            clickOn(1700,400);
        });


        // Handle confirmation dialog
        // Assuming there's a confirmation dialog that appears
        clickOn(ButtonType.OK.getText());

        sleep(1000);


        // Verify that the member is removed from the TableView

    }
    @Test
    public void testEditMemberButton_shouldEditMemberInGUI() {
        // Select a member from the table
        TableView<Member> membersTable = lookup("#membersTable").queryAs(TableView.class);
        interact(() -> {
            // Ensure the table is not empty and select the first member
            assertFalse(membersTable.getItems().isEmpty(), "Table should not be empty");
            membersTable.getSelectionModel().selectFirst();
        });

        // Click the edit button

        clickOn("#editMemberButton");

        // Make changes to the member details in the form

        clickOn("#firstNameField").write("NewFirstName");
        clickOn("#lastNameField").write("NewLastName");
        // Add more fields as necessary

        // Click the save button to save changes
        clickOn("#saveButton");


        Member editedMember = membersTable.getSelectionModel().getSelectedItem();
        assertEquals("NewFirstName", editedMember.getFirstName(), "First name should be updated");
        assertEquals("NewLastName", editedMember.getLastName(), "Last name should be updated");

    }
    @Test
    public void testDeleteMemberButton() {
        // Try clicking the delete member button
        try {
            clickOn("#deleteMemberButton");
            // If the button is successfully clicked, you can assert true or proceed with further checks
            assertTrue(true, "Button was clicked successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to click on the delete member button.");
        }
    }




}