package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {

    private int invoiceNum;
    private String customerName;
    private Date date;
    private ArrayList<InvoiceLines> lines;
    private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNum=" + invoiceNum + ", customerName=" + customerName + ", date=" + df.format(date) + '}';
    }

    public InvoiceHeader(int invoiceNum, String customerName, Date date) {
        this.invoiceNum = invoiceNum;
        this.customerName = customerName;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date =  date;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
