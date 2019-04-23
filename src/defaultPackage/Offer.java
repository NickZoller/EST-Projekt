package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class Offer {

    private static Customer customer;
    private static List<QuotationItem> quotationItems = new ArrayList<>();

    /**
     * Sets the customer of the offer.
     * @param c the customer
     */
    public static void setCustomer(Customer c) {
        customer = c;
    }

    /**
     * @return the customer of the offer
     */
    public static Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the quotation items of the offer.
     * @param qItems
     */
    public static void setQuotationItems(List<QuotationItem> qItems) {
        quotationItems = qItems;
    }

    /**
     * @return the quotation items of the offer
     */
    public static List<QuotationItem> getQuotationItems() {
        return quotationItems;
    }
}