package defaultPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Method invoked at the launch of the application. Creates the primary stage and loads the initial scene of the
     * customer selection.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        generateCustomersAndProductionSteps();

        Parent root = FXMLLoader.load(getClass().getResource("/CustomerSelection.fxml"));
        primaryStage.setTitle("Angebotserstellung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Generates dummy objects for demo purposes and stores them locally.
     */
    private static void generateCustomersAndProductionSteps() {
        CustomerBase.add(new Customer("Kunde 1", "Straße 1"));
        CustomerBase.add(new Customer("Kunde 2", "Straße 2"));
        CustomerBase.add(new Customer("Kunde 3", "Straße 3"));

        ProductionSteps.add(new ProductionStep("Schritt 1", 80));
        ProductionSteps.add(new ProductionStep("Schritt 2", 150));
    }

}