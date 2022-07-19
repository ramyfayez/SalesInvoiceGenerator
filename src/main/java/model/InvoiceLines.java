package model;

public class InvoiceLines {

    private InvoiceHeader invoiceNum;
    private String itemName;
    private double itemPrice;
    private int count;

    public InvoiceLines(InvoiceHeader invoiceNum, String itemName, double itemPrice, int count) {
        this.invoiceNum = invoiceNum;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return "InvoiceLines{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", count=" + count + ", itemTotal=" + getItemTotal() + '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceHeader getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(InvoiceHeader invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemTotal() {
        return count * itemPrice;
    }

}
