package model;

import view.InvoiceFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class InvoiceHeaderTableModel extends AbstractTableModel {
    public static ArrayList<InvoiceHeader> data;
    private String[] cols = {"No", "Date", "Customer Name", "Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return header.getInvoiceNum();
            case 1:
                return InvoiceFrame.dateFormat.format(header.getDate());
            case 2:
                return header.getCustomerName();
            case 3:
                return header.getInvoiceTotal();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

}




