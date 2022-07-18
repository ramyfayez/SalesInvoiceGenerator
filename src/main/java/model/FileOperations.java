package model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static view.DesignPreview.*;

public class FileOperations extends JPanel {

    public static JTable invoiceTable;
    public static TabelModel NewModel;
    public static ArrayList<String[]> Rs2;
    private static ArrayList<String[]> invoiceTableData = new ArrayList<>();


    public FileOperations() {
        super(new BorderLayout(3, 3));
        invoiceTable = new JTable(new TabelModel());
        invoiceTable.setFillsViewportHeight(true);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(invoiceTable);

        // Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);

        // add a border
        setBorder(new EmptyBorder(10, 10, 50, 5));


        CSVFile Rd = new CSVFile();
        NewModel = new TabelModel();
        invoiceTable.setModel(NewModel);
        File DataFile = new File("src/main/resources/InvoiceHeader.csv");
        Rs2 = Rd.readFile(DataFile);
        NewModel.AddCSVData(Rs2);
        System.out.println("Rows: " + NewModel.getRowCount());
        System.out.println("Cols: " + NewModel.getColumnCount());


    }

    // Method for reading CSV file
    public static class CSVFile {
        private final ArrayList<String[]> Rs = new ArrayList<>();

        public ArrayList<String[]> readFile(File DataFile) {
            try {

                Scanner scan = new Scanner(DataFile);
                while (scan.hasNext()) {
                    String[] rowData = new String[4];
                    String[] oneRow = scan.next().split(",");
                    if (oneRow.length < 4) {
                        System.arraycopy(oneRow, 0, rowData, 0, oneRow.length);
                    } else {
                        rowData = oneRow;
                    }
                    Rs.add(rowData);
                }
            } // end of try
            catch (Exception e) {
                String errmsg = e.getMessage();
                System.out.println("File not found:" + errmsg);
            } // end of Catch
            return Rs;
        }// end of ReadFile method
    }// end of CSVFile class


    static class TabelModel extends AbstractTableModel {
        private final String[] invoiceTableCols = {"No.", "Date", "Customer", "Total"};


        public void AddCSVData(ArrayList<String[]> DataIn) {
            invoiceTableData = DataIn;
            this.fireTableDataChanged();
        }

        @Override
        public int getColumnCount() {
            return invoiceTableCols.length;// length;
        }

        @Override
        public int getRowCount() {
            return invoiceTableData.size();
        }

        @Override
        public String getColumnName(int col) {
            return invoiceTableCols[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return invoiceTableData.get(row)[col];
        }


        public void removeRow(int row) {

            invoiceTableData.remove(row);
            fireTableRowsDeleted(row - 1, invoiceTableData.size() - 1);

        }
    }

    public static void deleteRow() {
        System.out.println(invoiceTable.getSelectedRow());
        if (invoiceTable.getSelectedRow() > -1) {
            NewModel.removeRow(invoiceTable.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Selected row deleted successfully", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Row From Invoice Table", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void fetchRowData() {
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectRow = invoiceTable.getSelectedRow();
                invoiceNumberValueLabel.setText(NewModel.getValueAt(selectRow, 0).toString());
                invoiceDatatextField.setText(NewModel.getValueAt(selectRow, 1).toString());
                customerNmaetextField.setText(NewModel.getValueAt(selectRow, 2).toString());
                invoiceTotalLabel.setText(NewModel.getValueAt(selectRow, 3).toString());
            }
        });

    }
}






