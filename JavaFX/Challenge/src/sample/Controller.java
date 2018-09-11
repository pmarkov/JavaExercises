package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import sample.com.markov.contacts.Contact;
import sample.com.markov.contacts.ContactData;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private TableView<Contact> tableView;
    @FXML
    private TableColumn<Contact, String> firstNameColumn;
    @FXML
    private TableColumn<Contact, String> lastNameColumn;
    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;
    @FXML
    private TableColumn<Contact, String> notesColumn;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private MenuItem editMenuItem;
    @FXML
    private MenuItem deleteMenuItem;

    public void initialize() {

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        tableView.setItems(ContactData.getInstance().getContacts());
        if(!tableView.getItems().isEmpty()) {
            tableView.getSelectionModel().selectFirst();
        }

    }

    @FXML
    public void handleMenuOpen() {
        boolean disable = tableView.getItems().isEmpty();
        editMenuItem.setDisable(disable);
        deleteMenuItem.setDisable(disable);
    }

    @FXML
    public void handleAddContact() {

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addContactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Error loading dialog window");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        while(true) {
            Optional<ButtonType> result = dialog.showAndWait();

            if(result.isPresent()) {
                if(result.get().equals(ButtonType.OK)) {
                    AddContactController controller = fxmlLoader.getController();
                    Contact contact = controller.processResult();
                    if(contact != null) {
                        ContactData.getInstance().addContact(contact);
                        tableView.getSelectionModel().select(contact);
                        break;
                    }
                } else if(result.get().equals(ButtonType.CANCEL)) {
                    break;
                }
            }
        }
    }

    @FXML
    public void handleEditContact() {
        Contact contact = tableView.getSelectionModel().getSelectedItem();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Editing " + contact.getFirstName() + " " + contact.getLastName());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editContactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Error loading dialog window");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        while(true) {
            Optional<ButtonType> result = dialog.showAndWait();
            if(result.isPresent()) {
                if(result.get().equals(ButtonType.OK)) {
                    EditContactController controller = fxmlLoader.getController();
                    boolean success = controller.processResult(contact);
                    if(success) {
                        tableView.refresh();
//                        ContactData data = ContactData.getInstance();
//                        int index = data.getContacts().indexOf(contact);
//                        data.editContact(index, editedContact);
//                        tableView.getSelectionModel().select(editedContact);
                        break;
                    }
                } else if(result.get().equals(ButtonType.CANCEL)) {
                    break;
                }
            }
        }


    }

    @FXML
    public void handleDeleteContact() {
        Contact contact = tableView.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete Contact");
        alert.setHeaderText("Deleting contact: " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Do you really want to delete this contact?");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get().equals(ButtonType.OK)) {
            ContactData.getInstance().deleteContact(contact);
        }
    }

}
