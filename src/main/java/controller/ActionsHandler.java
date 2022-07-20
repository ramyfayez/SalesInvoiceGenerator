package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLines;
import model.InvoiceLinesTableModel;
import view.CraeteNewInvoiceDialog;
import view.CreateNewItemDialog;
import view.InvoiceFrame;


import static view.CraeteNewInvoiceDialog.customerNameCrInF;
import static view.CraeteNewInvoiceDialog.dateCrInF;
import static view.CreateNewItemDialog.*;
import static view.InvoiceFrame.*;

public class ActionsHandler implements ActionListener, ListSelectionListener {

    public static InvoiceFrame frame;
    private CraeteNewInvoiceDialog createNewInvDialog;
    private CreateNewItemDialog createNewItemDialog;

    public ActionsHandler(InvoiceFrame frame) {
        ActionsHandler.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load File" -> {
                System.out.println("Load File Menu Item Pressed");
                loadFile();
                FileOperations.readFilesData();
            }
            case "Save File" -> {
                System.out.println("Save File Menu Item Pressed");
                vaildateMessage("Save File");
            }
            case "Create New Invoice" -> {
                System.out.println("Create New Invoice Button Pressed");
                vaildateMessage("Create New Invoice");
            }
            case "Delete Invoice" -> {
                System.out.println("Delete Invoice Button Pressed");
                vaildateMessage("Delete Invoice");
            }
            case "Create New Item" -> {
                System.out.println("Create New Item Button Pressed");
                vaildateMessage("Create New Item");
            }
            case "Delete Item" -> {
                System.out.println("Delete Item Button Pressed");
                vaildateMessage("Delete Item");
            }
            case "newInvoiceOK" -> {
                System.out.println("Create New Invoice Ok Button Pressed");
                if (customerNameCrInF.getText().trim().isEmpty() || dateCrInF.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(createNewInvDialog, "Customer Name and Date:(DD-MM-YYYY) are mandatory ", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    newInvoiceDialogOKBtn();
                }
            }
            case "newInvoiceCancel" -> {
                System.out.println("Create New Invoice Cancel Button Pressed");
                newInvoiceDialogCancelBtn();
            }
            case "newItemOKBtn" -> {
                System.out.println("Create New Item Button Pressed");
                if (itemCountCrF.getText().trim().isEmpty() || itemNameCrF.getText().trim().isEmpty() || itemPriceCrF.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(createNewItemDialog, "Item Name, ItemCount and Item Price Fields are mandatory ", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    newItemDialogOkBtn();
                }

            }
            case "newItemCancelBtn" -> {
                System.out.println("Create New Item Button Pressed");
                newItemCancelBtn();
            }
            default -> throw new AssertionError();
        }
    }

    private void newItemCancelBtn() {
        createNewItemDialog.setVisible(false);
        createNewItemDialog.dispose();
        createNewItemDialog = null;
    }

    private void newItemDialogOkBtn() {
        createNewItemDialog.setVisible(false);

        String itemNameStr = createNewItemDialog.getItemNameField().getText();
        String itemCountStr = createNewItemDialog.getItemCountField().getText();
        String itemPriceStr = createNewItemDialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(itemCountStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(createNewItemDialog, "Count entered in wrong format, reset to: 1", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(itemPriceStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(createNewItemDialog, "Price entered in wrong format, reset to: 1", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvHeader = frame.getInvoiceTable().getSelectedRow();
        if (selectedInvHeader != -1) {
            InvoiceHeader invHeader = frame.getInvoiceHeaderList().get(selectedInvHeader);
            InvoiceLines item = new InvoiceLines(invHeader, itemNameStr, price, count);
            InvoiceLinesTableModel.itemsData.add(item);
            InvoiceLinesTableModel itemsTableModel = (InvoiceLinesTableModel) frame.getInvoiceItemsTable().getModel();
            itemsTableModel.fireTableDataChanged();
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        }
        frame.getInvoiceTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        createNewItemDialog.dispose();
        createNewItemDialog = null;
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
                Thread.sleep(500);
                result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String lineStrPath = fileChooser.getSelectedFile().getAbsolutePath();
                    Path linePath = Paths.get(lineStrPath);
                    List<String> lineLines = Files.lines(linePath).toList();
                    for (String lineItems : lineLines) {
                        String[] itemParts = lineItems.split(",");
                        int invID = Integer.parseInt(itemParts[0]);
                        double price = Double.parseDouble(itemParts[2]);
                        int count = Integer.parseInt(itemParts[3]);
                        InvoiceHeader header = getInvoiveHeaderById(invoiceHeaderList, invID);
                        InvoiceLines invLine = new InvoiceLines(header, itemParts[1], price, count);
                        assert header != null;
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
        ArrayList<InvoiceHeader> invoicesArray = frame.getInvoiceHeaderList();
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                StringBuilder headers = new StringBuilder();
                StringBuilder lines = new StringBuilder();
                for (InvoiceHeader invoice : invoicesArray) {
                    headers.append(invoice.toString());
                    headers.append("\n");
                    for (InvoiceLines line : invoice.getLines()) {
                        lines.append(line.toString());
                        lines.append("\n");
                    }
                }
                headers = new StringBuilder(headers.substring(0, headers.length() - 1));
                lines = new StringBuilder(lines.substring(0, lines.length() - 1));
                Thread.sleep(500);
                fc.showSaveDialog(frame);
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                hfw.write(headers.toString());
                lfw.write(lines.toString());
                hfw.close();
                lfw.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        Date invDate = new Date();
        try {
            invDate = InvoiceFrame.dateFormat.parse(dateStr);
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
        InvoiceHeader newInv = new InvoiceHeader(invNum, custName, invDate);
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
        createNewItemDialog = new CreateNewItemDialog(frame);
        createNewItemDialog.setVisible(true);
        createNewItemDialog.setTitle("Create New Items Form");
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

    public void vaildateMessage(String methodName) {
        switch (methodName) {
            case "Create New Invoice":
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    createNewInvoice();
                }
                break;
            case "Create New Item":
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else if (frame.getInvoiceTable().getSelectedRow() != -1) {
                    createNewItem();
                    JOptionPane.showMessageDialog(createNewItemDialog, """
                                    Items Name: Text
                                    Item Count: Numbers only ex.1
                                    Item Price: Numbers only ex.1.1
                                    """
                            , "Fields Input Format", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(createNewItemDialog, "First: Select Invoice", "Select Invoice", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Delete Invoice":
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    deleteInvoice();
                }
                break;
            case "Delete Item":
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    deleteItem();
                }
                break;
            case "Save File":
                if (frame.getInvoiceTable().getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "First: Load File", "Load File", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    saveFile();
                }
                break;
        }
    }

}

