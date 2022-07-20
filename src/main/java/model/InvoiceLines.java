package model;

public class InvoiceLines {

    private final InvoiceHeader invoiceNum;
    private final String itemName;
    private final double itemPrice;
    private final int count;

    public InvoiceLines(InvoiceHeader invoiceNum, String itemName, double itemPrice, int count) {
        this.invoiceNum = invoiceNum;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return invoiceNum.getInvoiceNum() + "," + itemName + "," + itemPrice + "," + count;
    }

    public int getCount() {
        return count;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getItemTotal() {
        return count * itemPrice;
    }

}
