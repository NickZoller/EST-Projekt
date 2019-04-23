package defaultPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerSelectionController implements Initializable {

    @FXML private ComboBox CustomerList;
    @FXML private Button NewCustomer;

    /**
     * Clears the QuotationItems list so that quotation items will not be stored anymore if the user decides to go back
     * to the user selection. Fills the CustomerList ComboBox with values stored in the CustomerBase class.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuotationItems.getAll().clear();
        CustomerList.getItems().clear();
        CustomerList.getItems().add("Neuer Kunde");
        CustomerList.getItems().addAll(CustomerBase.getAll());

    }

    /**
     * Checks if the ComboBox is set to "Neuer Kunde" and, if so, makes the NewCustomer Button visible.
     */
    @FXML
    private void checkForNewCustomer() {
        NewCustomer.setVisible(CustomerList.getValue().equals("Neuer Kunde"));
    }

    /**
     * Changes the scene to the one of the customer creation.
     * @throws IOException
     */
    @FXML
    private void addNewCustomer() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/NewCustomer.fxml"));
        Stage stage = (Stage) NewCustomer.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Checks the CustomerList ComboBox for holding a valid value and, if so, changes the scene to the one of the
     * quotation item adding.
     * @throws IOException
     */
    @FXML
    private void nextStep() throws IOException {
        if(CustomerList.getValue() == null || CustomerList.getValue().equals("Neuer Kunde")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehler");
            alert.setContentText("Sie müssen einen Kunden auswählen.");
            alert.showAndWait();
        } else {
            Offer.setCustomer((Customer)CustomerList.getValue());
            Parent root = FXMLLoader.load(getClass().getResource("/AddQuotationItem.fxml"));
            Stage stage = (Stage) NewCustomer.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}