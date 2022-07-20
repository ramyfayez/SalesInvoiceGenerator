package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {

    private final int invoiceNum;
    private final String customerName;
    private final Date date;
    private ArrayList<InvoiceLines> lines;
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public String toString() {
        return invoiceNum + "," + df.format(date) + "," + customerName;
    }

    public InvoiceHeader(int invoiceNum, String customerName, Date date) {
        this.invoiceNum = invoiceNum;
        this.customerName = customerName;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLines> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceLines lines : getLines()) {
            total += lines.getItemTotal();
        }
        return total;
    }
}
