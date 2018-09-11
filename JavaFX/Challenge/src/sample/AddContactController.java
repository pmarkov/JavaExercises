package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.com.markov.contacts.Contact;

public class AddContactController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;
    @FXML
    private Label errorMessageLabel;

    public Contact processResult() {

        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesField.getText().trim();

        if(firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || notes.isEmpty()) {
            errorMessageLabel.setText("You have to fill every field!");
            return null;
        }
        return new Contact(firstName, lastName, phoneNumber, notes);
    }
}
