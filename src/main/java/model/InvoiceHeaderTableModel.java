package model;

import view.InvoiceFrame;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class InvoiceHeaderTableModel extends AbstractTableModel {
    public static ArrayList<InvoiceHeader> data;
    private final String[] cols = {"No", "Date", "Customer Name", "Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> data) {
        InvoiceHeaderTableModel.data = data;
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
        return switch (columnIndex) {
            case 0 -> header.getInvoiceNum();
            case 1 -> InvoiceFrame.dateFormat.format(header.getDate());
            case 2 -> header.getCustomerName();
            case 3 -> header.getInvoiceTotal();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

}




