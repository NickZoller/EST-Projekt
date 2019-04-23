package defaultPackage;

public class QuotationItem {

    private ProductionStep productionStep;
    private double amount;
    private double price;

    /**
     * Constructor that calculates the price based on the costs of the production step and the amount. The price needs
     * to be stored here, otherwise it would change if the costs of the production step change.
     * @param pStep
     * @param amount
     */
    public QuotationItem(ProductionStep pStep, double amount) {
        productionStep = pStep;
        this.amount = amount;
        price = pStep.getCosts() * amount;
    }

    /**
     * @return production step
     */
    public ProductionStep getProductionStep() {
        return productionStep;
    }

    /**
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}