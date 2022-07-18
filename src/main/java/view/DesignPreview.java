package view;

import model.FileOperations;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class DesignPreview extends JFrame implements ActionListener {
    private JMenuBar menubar; // Menu Bar variable
    private JMenu file; // Title for first menu includes 2 items
    private JMenuItem loadFile; // Menu Item 1
    private JMenuItem saveFile; // Menu Item 2
    private JTable invoiceItemTable; // Invoice Item Table on right panel
    private String[] invoiceItemscols = {"No.", "Item Name", "Item Price", "Count", "Item Total"}; // Header for Invoice Items Table
    private String[][] invoiceItemsdata = {}; // Data for Invoice Items Table
    private JButton createNewInvoiceBtn; // Create new Invoice button
    private JButton deleteInvoiceBtn;    // Delete Invoice button
    private JButton saveInvoiceItemBtn;  // Save Invoice Item button
    private JButton cancelInvoiceItemBtn; // Discard changesInvoice Item button
    private JPanel mainPanel; // Main panel contain left and right panels
    private JPanel leftPanel; // Left panel include invoice table and create and delete button
    private JPanel rightPanel; // Right panel include invoice panel details, invoice item table, save button and cancel button
    private JPanel leftPanelButtons; // Include create and Delete buttons
    private JPanel rightPanelButtons; // Include Save and Cancel buttons
    public static JLabel invoiceNumberValueLabel;
    public static JTextField invoiceDatatextField;
    public static JTextField customerNmaetextField;
    public static JLabel invoiceTotalLabel;


    public DesignPreview() {
        super("Design Preview [NewJFrame]");
        //Menu bar and items configuration
        menubar = new JMenuBar();
        file = new JMenu("File");

        //Load file item
        loadFile = new JMenuItem("Load File", 'L');
        loadFile.setAccelerator(KeyStroke.getKeyStroke('L', KeyEvent.CTRL_DOWN_MASK));
        loadFile.addActionListener(this);
        loadFile.setActionCommand("L");

        //Save file item
        saveFile = new JMenuItem("Save File", 'S');
        saveFile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        //loadFile.addActionListener(this);
        saveFile.setActionCommand("S");

        //Add Menu bar components
        setJMenuBar(menubar);
        menubar.add(file);
        file.add(loadFile);
        file.add(saveFile);


        //Configure Main panel and components
        mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));


        //Left Panel Components
        leftPanel = new JPanel(); //Sub panel 1
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Invoices Table", TitledBorder.LEFT, TitledBorder.TOP));


        //Invoice Table
        FileOperations newContentPane = new FileOperations();
        leftPanel.add(newContentPane);


        //Buttons Create and Delete configuration
        leftPanelButtons = new JPanel();
        leftPanelButtons.setLayout(new BoxLayout(leftPanelButtons, BoxLayout.X_AXIS));

        Box hBoxLeftPanel = Box.createHorizontalBox();

        //Create New Invoice Button
        createNewInvoiceBtn = new JButton("Create New Invoice");
        createNewInvoiceBtn.setBackground(Color.lightGray);
        hBoxLeftPanel.add(createNewInvoiceBtn);

        //Delete Invoice Button
        deleteInvoiceBtn = new JButton("Delete Invoice");
        deleteInvoiceBtn.setActionCommand("D");
        deleteInvoiceBtn.addActionListener(this);
        deleteInvoiceBtn.setBackground(Color.lightGray);
        hBoxLeftPanel.add(Box.createHorizontalStrut(50));
        hBoxLeftPanel.add(deleteInvoiceBtn);
        leftPanelButtons.add(hBoxLeftPanel);


        //Right Panel Components
        rightPanel = new JPanel(); // sub-panel 2
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));


        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setLayout(new GridLayout(4, 2));
        JLabel invoiceNumberLabel = new JLabel("Invoice Number");
        rightTopPanel.add(invoiceNumberLabel);
        invoiceNumberValueLabel = new JLabel("");
        rightTopPanel.add(invoiceNumberValueLabel);


        JLabel invoiceDataLabel = new JLabel("Invoice Date");
        rightTopPanel.add(invoiceDataLabel);
        invoiceDatatextField = new JTextField(15);
        rightTopPanel.add(invoiceDatatextField);


        JLabel customerNameLabel = new JLabel("Customer Name");
        rightTopPanel.add(customerNameLabel);
        customerNmaetextField = new JTextField(15);
        rightTopPanel.add(customerNmaetextField);

        JLabel invoiceTotal = new JLabel("Invoice Total");
        rightTopPanel.add(invoiceTotal);
        invoiceTotalLabel = new JLabel("");
        rightTopPanel.add(invoiceTotalLabel);

        //Invoice Items Table
        JPanel invoiceItemsTablePanel = new JPanel();
        invoiceItemsTablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Invoices Items", TitledBorder.LEFT, TitledBorder.TOP));

        invoiceItemTable = new JTable(invoiceItemsdata, invoiceItemscols);
        invoiceItemsTablePanel.add(new JScrollPane(invoiceItemTable));


        Box hBoxrightPanel = Box.createHorizontalBox();
        //Buttons Save and Cancel configuration
        rightPanelButtons = new JPanel();
        rightPanelButtons.setLayout(new BoxLayout(rightPanelButtons, BoxLayout.X_AXIS));

        //Save Invoice Button
        saveInvoiceItemBtn = new JButton("Save");
        saveInvoiceItemBtn.setBackground(Color.lightGray);
        hBoxrightPanel.add(saveInvoiceItemBtn);

        //Cancel Invoice Button
        cancelInvoiceItemBtn = new JButton("Cancel");
        cancelInvoiceItemBtn.setBackground(Color.lightGray);
        hBoxrightPanel.add(Box.createHorizontalStrut(50));
        hBoxrightPanel.add(cancelInvoiceItemBtn);
        rightPanelButtons.add(hBoxrightPanel);


        //Add components to display on Jframe
        leftPanel.add(leftPanelButtons);
        rightPanel.add(rightTopPanel);
        rightPanel.add(invoiceItemsTablePanel);
        rightPanel.add(rightPanelButtons);
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        add(mainPanel);


        //Frame proerties

        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new DesignPreview().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileOperations.fetchRowData();
        switch (e.getActionCommand()) {
            case "L":
                leftPanel.removeAll();
                FileOperations newContentPane = new FileOperations();
                leftPanel.add(newContentPane);
                leftPanel.add(leftPanelButtons);
                leftPanel.validate();
                leftPanel.repaint();
                break;
            case "D":
                FileOperations.deleteRow();
                break;

        }

    }

}


