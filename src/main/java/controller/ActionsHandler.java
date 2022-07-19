package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.InvoiceHeader;
import model.InvoiceLines;
import model.InvoiceLinesTableModel;
import view.CraeteNewInvoiceDialog;
import view.InvoiceFrame;


import static view.CraeteNewInvoiceDialog.customerNameCrInF;
import static view.InvoiceFrame.*;

public class ActionsHandler implements ActionListener, ListSelectionListener {

    public static InvoiceFrame frame;
    private CraeteNewInvoiceDialog createNewInvDialog;

    public ActionsHandler(InvoiceFrame frame) {
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File" -> {
                System.out.println("Load File Menu Item Pressed");
                loadFile();
            }
            case "Save File" -> {
                System.out.println("Save File Menu Item Pressed");
                saveFile();
            }
            case "Create New Invoice" -> {
                System.out.println("Create New Invoice Button Pressed");
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("Table not empty checked");
                    createNewInvoice();
                }
            }
            case "Delete Invoice" -> {
                System.out.println("Delete Invoice Button Pressed");
                deleteInvoice();
            }
            case "Create New Item" -> {
                System.out.println("Create New Item Button Pressed");
                createNewItem();
            }
            case "Delete Item" -> {
                System.out.println("Delete Item Button Pressed");
                deleteItem();
            }
            case "newInvoiceOK" -> {
                System.out.println("Create New Invoice Ok Button Pressed");
                if (customerNameCrInF.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(createNewInvDialog, "Customer Name and Date:(DD-MM-YYYY) are mandatory ", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    newInvoiceDialogOKBtn();

                }
            }
            case "newInvoiceCancel" -> {
                System.out.println("Create New Invoice Cancel Button Pressed");
                newInvoiceDialogCancelBtn();
            }
            default -> throw new AssertionError();
        }
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                String headerSTrpath = headerFile.getAbsolutePath();
                Path headerPath = Paths.get(headerSTrpath);
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<InvoiceHeader> invoiceHeaderList = new ArrayList<>();
                for (String headerline : headerLines) {
                    String[] parts = headerline.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String dateStr = parts[1];
                    Date invoiceDate = InvoiceFrame.dateFormat.parse(dateStr);
                    InvoiceHeader invHeader = new InvoiceHeader(id, parts[2], invoiceDate);
                    invoiceHeaderList.add(invHeader);
                }
                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String lineStrPath = fileChooser.getSelectedFile().getAbsolutePath();
                    Path linePath = Paths.get(lineStrPath);
                    List<String> lineLines = Files.lines(linePath).collect(Collectors.toList());
                    for (String lineItems : lineLines) {
                        String[] itemParts = lineItems.split(",");
                        int invID = Integer.parseInt(itemParts[0]);
                        double price = Double.parseDouble(itemParts[2]);
                        int count = Integer.parseInt(itemParts[3]);
                        InvoiceHeader header = getInvoiveHeaderById(invoiceHeaderList, invID);
                        InvoiceLines invLine = new InvoiceLines(header, itemParts[1], price, count);
                        header.getLines().add(invLine);
                    }
                    frame.setInvoiceHeaderList(invoiceHeaderList);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }


    }

    private InvoiceHeader getInvoiveHeaderById(ArrayList<InvoiceHeader> invoices, int id) {
        for (InvoiceHeader invoice : invoices) {
            if (invoice.getInvoiceNum() == id) {
                return invoice;
            }
        }
        return null;
    }

    private void saveFile() {
    }

    private void createNewInvoice() {
        createNewInvDialog = new CraeteNewInvoiceDialog(frame);
        createNewInvDialog.setVisible(true);
        createNewInvDialog.setTitle("Create New Invoice Form");
    }

    private void newInvoiceDialogCancelBtn() {
        createNewInvDialog.setVisible(false);
        createNewInvDialog.dispose();
        createNewInvDialog = null;
    }

    private void newInvoiceDialogOKBtn() {
        createNewInvDialog.setVisible(false);
        String custName = createNewInvDialog.getCustNameField().getText();
        String dateStr = createNewInvDialog.getInvDateField().getText();
        Date d = new Date();
        try {
            d = InvoiceFrame.dateFormat.parse(dateStr);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Date entered in wrong format, reset until today", "Invalid Date", JOptionPane.INFORMATION_MESSAGE);
        }
        int invNum = 0;
        for (InvoiceHeader inv : frame.getInvoiceHeaderList()) {
            if (inv.getInvoiceNum() > invNum) {
                invNum = inv.getInvoiceNum();
            }
        }
        invNum++;
        InvoiceHeader newInv = new InvoiceHeader(invNum, custName, d);
        frame.getInvoiceHeaderList().add(newInv);
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        createNewInvDialog.dispose();
        createNewInvDialog = null;
    }


    private void deleteInvoice() {
        int selectedRowDeleted = frame.getInvoiceTable().getSelectedRow();
        if (selectedRowDeleted != -1) {
            frame.getInvoiceHeaderList().remove(selectedRowDeleted);
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
            frame.getInvoiceItemsTable().setModel(new InvoiceLinesTableModel(null));
            frame.getLinesArray();
            invoiceNoValue.setText("");
            invoiceCustomerNValue.setText("");
            invoiceCustomerNValue.setText("");
            invoiceDateValue.setText("");
            invoiceTotalValue.setText("");
            JOptionPane.showMessageDialog(null, "Invoice Deleted Successfully", "Invoice Table Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Invoice From Table", "Invoice Table Message", JOptionPane.PLAIN_MESSAGE);

        }
    }

    private void createNewItem() {
    }

    private void deleteItem() {
        int selectedLineIndex = frame.getInvoiceItemsTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getInvoiceTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            InvoiceLinesTableModel.itemsData.remove(selectedLineIndex);
            InvoiceLinesTableModel lineTableModel = (InvoiceLinesTableModel) frame.getInvoiceItemsTable().getModel();
            lineTableModel.fireTableDataChanged();
            invoiceTotalValue.setText("" + frame.getInvoiceHeaderList().get(selectedInvoiceIndex).getInvoiceTotal());
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
            frame.getInvoiceTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
            JOptionPane.showMessageDialog(null, "Item Deleted Successfully", "Items Table Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Item From Table", "Items Table Message", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoiceTable().getSelectedRow();
        if (selectedRow != -1) {
            ArrayList<InvoiceLines> lines = frame.getInvoiceHeaderList().get(selectedRow).getLines();
            frame.getInvoiceItemsTable().setModel(new InvoiceLinesTableModel(lines));
            invoiceNoValue.setText(frame.getInvoiceTable().getValueAt(selectedRow, 0).toString());
            invoiceDateValue.setText(frame.getInvoiceTable().getValueAt(selectedRow, 1).toString());
            invoiceCustomerNValue.setText(frame.getInvoiceTable().getValueAt(selectedRow, 2).toString());
            invoiceTotalValue.setText(frame.getInvoiceTable().getValueAt(selectedRow, 3).toString());
        }
    }
}

