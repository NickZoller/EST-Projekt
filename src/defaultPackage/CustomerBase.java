package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class CustomerBase {

    private static List<Customer> customers = new ArrayList<>();

    /**
     * @param customer customer to be added
     */
    public static void add(Customer customer) {
        customers.add(customer);
    }

    /**
     * @return the customer base
     */
    public static List<Customer> getAll() {
        return customers;
    }

}
