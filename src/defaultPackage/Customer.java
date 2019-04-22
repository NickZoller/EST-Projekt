package defaultPackage;

public class Customer {

    private int id;
    private String name;
    private String address;

    /**
     * Constructor that creates a unique user ID.
     * @param name
     * @param address
     */
    public Customer(String name, String address) {
        id = CustomerBase.getAll().size();
        this.name = name;
        this.address = address;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Overrides the toString method so that the whole customer object can be bound to the ComboBox in the user
     * selection scene. The ComboBox will show what is returned here.
     * @return name
     */
    @Override
    public String toString() {
        return name;
    }

}
