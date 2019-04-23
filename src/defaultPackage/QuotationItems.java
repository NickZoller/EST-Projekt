package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class QuotationItems {

    private static List<QuotationItem> qItems = new ArrayList<>();

    /**
     * @param qItem quotation item to be added
     */
    public static void add(QuotationItem qItem) {
        qItems.add(qItem);
    }

    /**
     * @return the quotation items
     */
    public static List<QuotationItem> getAll() {
        return qItems;
    }

}