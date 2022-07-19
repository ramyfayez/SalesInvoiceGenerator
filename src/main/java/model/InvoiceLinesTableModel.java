package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvoiceLinesTableModel extends AbstractTableModel {
    public static ArrayList<InvoiceLines> itemsData;
    private String[] cols = {"Item Name", "Item Price", "Count", "Item Total"};


    public InvoiceLinesTableModel(ArrayList<InvoiceLines> itemsData) {
        this.itemsData = itemsData;
    }


    @Override
    public int getRowCount() {
        return itemsData == null ? 0 : itemsData.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (itemsData == null) {
            return "";
        } else {
            InvoiceLines line = itemsData.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return line.getItemName();
                case 1:
                    return line.getItemPrice();
                case 2:
                    return line.getCount();
                case 3:
                    return line.getItemTotal();
            }
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
}
