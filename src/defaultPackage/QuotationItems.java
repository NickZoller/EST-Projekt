package defaultPackage;

import java.util.ArrayList;
import java.util.List;

public class QuotationItems {

    private static List<QuotationItem> qItems = new ArrayList<>();

    /**
     * Adds a quotation item to the quotation items collection if the production step was not used in an already added
     * quotation item. If it was already used, the amounts of both quotation items will be summed.
     * @param qItem quotation item to be added
     */
    public static void add(QuotationItem qItem) {
        Boolean pStepAlreadyUsed = false;
        for (QuotationItem q : qItems) {
            if (q.getProductionStep().getId() == qItem.getProductionStep().getId()) {
                q.setAmount(q.getAmount() + qItem.getAmount());
                pStepAlreadyUsed = true;
                break;
            }
        }
        if (!pStepAlreadyUsed) {
            qItems.add(qItem);
        }
    }

    /**
     * @return the quotation items
     */
    public static List<QuotationItem> getAll() {
        return qItems;
    }

}