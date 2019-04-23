package defaultPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddQuotationItemController implements Initializable {

    @FXML private ComboBox ProductionStepList;
    @FXML private TextField amountField;

    @FXML private TableView<String> JobTable;
    @FXML private TableColumn job;

    /**
     * Fills the ProductionStepList ComboBox with values stored in the ProductionSteps class.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProductionStepList.getItems().clear();
        ProductionStepList.getItems().addAll(ProductionSteps.getAll());
    }

    /**
     * Changes the scene to the one of the previous step.
     * @throws IOException
     */
    @FXML
    private void backToPreviousStep() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CustomerSelection.fxml"));
        Stage stage = (Stage) amountField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Saves the quotation item entered by the user to the local storage and reloads the current scene to provide the
     * possibility of adding another quotation item.
     * @throws IOException
     */
    @FXML
    private void addAnotherQuotationItem() throws IOException {
        addQItemToQList();
        Parent root = FXMLLoader.load(getClass().getResource("/AddQuotationItem.fxml"));
        Stage stage = (Stage) amountField.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Saves the quotation item entered by the user and all previously entered items, saves them to the local storage
     * and switches the scene to the offer overview.
     * @throws IOException
     */
    @FXML
    private void finishOffer() throws IOException {
        if (addQItemToQList()) {
            Offer.setQuotationItems(QuotationItems.getAll());
            Parent root = FXMLLoader.load(getClass().getResource("/OfferOverview.fxml"));
            Stage stage = (Stage) amountField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    /**
     * Checks the entered quotation item for correctness and, if it is correct, saves it to the local storage.
     */
    private Boolean addQItemToQList() {
        ProductionStep pStep = (ProductionStep)ProductionStepList.getValue();
        double amount = 0;
        try {
            amount = Double.parseDouble(amountField.getText());
        } catch (NumberFormatException e) {
            alert("Die Menge muss eine Zahl sein.");
        }
        if (pStep != null && amount > 0) {
            QuotationItems.add(new QuotationItem((ProductionStep)ProductionStepList.getValue(), amount));
            return true;
        } else if (amount <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert("Die Menge muss größer als 0 sein.");
            return false;
        } else {
            alert("Sie müssen einen Posten auswählen.");
            return false;
        }
    }

    /**
     * Opens an alert dialog with a custom message.
     * @param message
     */
    private void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setHeaderText("Fehler");
        alert.setContentText(message);
        alert.showAndWait();
    }

}