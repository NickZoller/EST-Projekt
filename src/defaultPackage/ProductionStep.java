package defaultPackage;

public class ProductionStep {

    private int id;
    private String name;
    private double costs;

    /**
     * constructor
     * @param name
     * @param costs
     */
    public ProductionStep(String name, double costs) {
        id = ProductionSteps.getAll().size();
        this.name = name;
        this.costs = costs;
    }

    /**
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return costs
     */
    public double getCosts() {
        return costs;
    }

    /**
     * Overrides the toString method so that the whole production step object can be bound to the ComboBox in the
     * quotation item adding scene. The ComboBox will show what is returned here.
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

    public boolean equals(ProductionStep pStep) {
        return this.id == pStep.getId();
    }

}