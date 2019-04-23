package defaultPackage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class OfferOverviewController implements Initializable {

    @FXML private Label customer;
    @FXML private Label qItems;

    /**
     * Fills the two Labels customer and qItems with the local data stored during the creation of the offer.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String customerText = "Kunde: " + Offer.getCustomer().getName() + ", " + Offer.getCustomer().getAddress();
        customer.setText(customerText);
        String qItemsText = "Einzelposten:";
        for (QuotationItem qItem : Offer.getQuotationItems()) {
            qItemsText = qItemsText + "\n" + qItem.getProductionStep().getName() + " (" + qItem.getAmount() + " mal), " + qItem.getPrice() + "€";
        }
        qItems.setText(qItemsText);
    }

    /**
     * Closes the application.
     */
    @FXML
    private void exit() {
        Stage stage = (Stage)customer.getScene().getWindow();
        stage.close();
    }

    /**
     * Saves the offer and closes the application.
     */
    @FXML
    private void save() {
        /* *TODO* Actually save the data to a database. */
        exit();
    }
}
