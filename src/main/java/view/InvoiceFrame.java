/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ActionsHandler;
import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Ramy_fayz
 */
public class InvoiceFrame extends javax.swing.JFrame {

    public InvoiceFrame() {
        super("Invoice Sales Generator");
        handler = new ActionsHandler(this);
        initComponents();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(handler);
        // Variables declaration - do not modify
        JButton createNewInvoiceBtn = new JButton();
        createNewInvoiceBtn.addActionListener(handler);
        JButton deleteInvoiceBtn = new JButton();
        deleteInvoiceBtn.addActionListener(handler);
        JLabel invoiceTableLabel = new JLabel();
        JLabel invoiceNolabel = new JLabel();
        JLabel invoiceDateLabel = new JLabel();
        JLabel invoiceCustomerNLabel = new JLabel();
        JLabel invoiceTotalLabel = new JLabel();
        invoiceNoValue = new javax.swing.JLabel();
        invoiceDateValue = new javax.swing.JLabel();
        invoiceCustomerNValue = new javax.swing.JLabel();
        invoiceTotalValue = new javax.swing.JLabel();
        JLabel invoiceItemsLabel = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        invoiceItemsTable = new javax.swing.JTable();
        JButton createNewItemBtn = new JButton();
        createNewItemBtn.addActionListener(handler);
        JButton deleteItemBtn = new JButton();
        deleteItemBtn.addActionListener(handler);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu();
        JMenuItem loadMenuItem = new JMenuItem();
        loadMenuItem.addActionListener(handler);
        JMenuItem saveMenuItem = new JMenuItem();
        saveMenuItem.addActionListener(handler);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        createNewInvoiceBtn.setText("Create New Invoice");

        deleteInvoiceBtn.setText("Delete Invoice");

        invoiceTableLabel.setText("Invoice Table");

        invoiceNolabel.setText("Invoice NO.");

        invoiceDateLabel.setText("Invoice Date");

        invoiceCustomerNLabel.setText("Customer Name");

        invoiceTotalLabel.setText("Invoice Total");

        invoiceItemsLabel.setText("Invoice Items");

        invoiceItemsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                }
        ));
        jScrollPane2.setViewportView(invoiceItemsTable);

        createNewItemBtn.setText("Create New Item");

        deleteItemBtn.setText("Delete Item");

        fileMenu.setText("File");

        loadMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        loadMenuItem.setMnemonic('L');
        loadMenuItem.setText("Load File");
        fileMenu.add(loadMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setMnemonic('S');
        saveMenuItem.setText("Save File");
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(invoiceTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(invoiceCustomerNLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(invoiceCustomerNValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(invoiceTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(invoiceNolabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(invoiceDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(invoiceNoValue, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(invoiceDateValue, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(invoiceItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(createNewInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(deleteInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(151, 151, 151)
                                                .addComponent(createNewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(deleteItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(invoiceTableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(invoiceTableLabel)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceNolabel)
                                                        .addComponent(invoiceNoValue))
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceDateLabel)
                                                        .addComponent(invoiceDateValue))
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceCustomerNLabel)
                                                        .addComponent(invoiceCustomerNValue))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceTotalLabel)
                                                        .addComponent(invoiceTotalValue))
                                                .addGap(18, 18, 18)
                                                .addComponent(invoiceItemsLabel)
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createNewInvoiceBtn)
                                        .addComponent(deleteInvoiceBtn)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(createNewItemBtn)
                                                .addComponent(deleteItemBtn)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InvoiceFrame().setVisible(true));
    }

    public static javax.swing.JLabel invoiceCustomerNValue;
    public static javax.swing.JLabel invoiceDateValue;
    private javax.swing.JTable invoiceItemsTable;
    public static javax.swing.JLabel invoiceNoValue;
    public static javax.swing.JTable invoiceTable;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    public static javax.swing.JLabel invoiceTotalValue;

    public ActionsHandler getHandler() {
        return handler;
    }

    public ArrayList<InvoiceHeader> getInvoiceHeaderList() {
        return invoiceHeaderList;
    }

    public void setInvoiceHeaderList(ArrayList<InvoiceHeader> invoiceHeaderList) {
        this.invoiceHeaderList = invoiceHeaderList;
        invoiceHeaderTableModel = new InvoiceHeaderTableModel(invoiceHeaderList);
        invoiceTable.setModel(invoiceHeaderTableModel);
    }

    public JTable getInvoiceItemsTable() {
        return invoiceItemsTable;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public InvoiceHeaderTableModel getInvoiceHeaderTableModel() {
        return invoiceHeaderTableModel;
    }


    private final ActionsHandler handler;
    private InvoiceHeaderTableModel invoiceHeaderTableModel;

    private ArrayList<InvoiceHeader> invoiceHeaderList;

    public void getLinesArray() {
    }


}
