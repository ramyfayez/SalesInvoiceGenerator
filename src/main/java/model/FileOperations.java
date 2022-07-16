package model;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations extends JPanel {

    public FileOperations() {
        super(new BorderLayout(3, 3));
        JTable invoiceTable = new JTable(new TabelModel());
        invoiceTable.setFillsViewportHeight(true);

        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(invoiceTable);

        // Add the scroll pane to this panel.
        add(scrollPane, BorderLayout.CENTER);

        // add a border
        setBorder(new EmptyBorder(10, 10, 50, 5));


        CSVFile Rd = new CSVFile();
        TabelModel NewModel = new TabelModel();
        invoiceTable.setModel(NewModel);
        File DataFile = new File("src/main/resources/InvoiceHeader.csv");
        ArrayList<String[]> Rs2 = Rd.readFile(DataFile);
        System.out.println(Rs2);
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
                    if(oneRow.length < 4){
                        System.arraycopy(oneRow, 0, rowData, 0, oneRow.length);
                    }else {
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
        private ArrayList<String[]> invoiceTableData = new ArrayList<>();

        public void AddCSVData(ArrayList<String[]> DataIn) {
            this.invoiceTableData = DataIn;
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

    }

}
