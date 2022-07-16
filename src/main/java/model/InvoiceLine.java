package model;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class InvoiceLine extends ArrayList<InvoiceLine> {
    int invoiceNum;

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    String itemName;
    Double itemPrice;
    int count;


    public InvoiceLine(int invoiceNum, String itemName, Double itemPrice, int count) {
        this.itemName = itemName;
        this.invoiceNum = invoiceNum;
        this.itemPrice = itemPrice;
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceLine() {

    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }
}
