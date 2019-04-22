package defaultPackage;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewCustomerController implements Initializable {

    @FXML private TextField customerName;
    @FXML private TextField customerAddress;

    /**
     * Changes the scene focus to the parent element of the customerName TextField so the prompt text of that TextField
     * is visible.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> customerName.getParent().requestFocus());
    }

    /**
     * Checks the user input for correctness and, if the input is correct, creates a new user object and saves it to
     * the local storage.
     * @throws IOException
     */
    @FXML
    private void saveNewCustomer() throws IOException {
        String name = customerName.getText();
        String address = customerAddress.getText();
        if(name.isBlank() || address.isBlank()) {
            customerName.setText("");
            customerAddress.setText("");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehler");
            alert.setContentText("Sie müssen Name und Adresse des Kunden eingeben.");
            alert.showAndWait();
        } else {
            CustomerBase.add(new Customer(name, address));
            backToFistStep();
        }
    }

    /**
     * Changes the scene to the one of the customer selection.
     * @throws IOException
     */
    @FXML
    private void backToFistStep() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerSelection.fxml"));
        Stage stage = (Stage) customerName.getScene().getWindow();
        stage.setTitle("Angebotserstellung");
        stage.setScene(new Scene(root));
        stage.show();
    }

}