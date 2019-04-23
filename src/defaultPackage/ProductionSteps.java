package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class ProductionSteps {

    private static List<ProductionStep> productionSteps = new ArrayList<>();

    /**
     * @param pStep production step to be added
     */
    public static void add(ProductionStep pStep) {
        productionSteps.add(pStep);
    }

    /**
     * @return the production steps
     */
    public static List<ProductionStep> getAll() {
        return productionSteps;
    }

}