package view;

import javax.swing.*;


public class CraeteNewInvoiceDialog extends JDialog {

    public CraeteNewInvoiceDialog(InvoiceFrame frame) {
        createNewInvoiceFormeL = new javax.swing.JLabel();
        customerNameCrInL = new javax.swing.JLabel();
        customerNameCrInF = new javax.swing.JTextField();
        dateCrInL = new javax.swing.JLabel();
        dateCrInF = new javax.swing.JTextField();
        okBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        customerNameCrInL.setText("Customer Name");

        dateCrInL.setText("Date");

        okBtn.setText("Ok");
        okBtn.setActionCommand("newInvoiceOK");
        cancelBtn.setActionCommand("newInvoiceCancel");

        okBtn.addActionListener(frame.getHandler());
        cancelBtn.addActionListener(frame.getHandler());

        cancelBtn.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(createNewInvoiceFormeL, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 309, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(dateCrInL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(customerNameCrInL, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(dateCrInF, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                                .addComponent(customerNameCrInF)))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(125, 125, 125)
                                                        .addComponent(okBtn)
                                                        .addGap(63, 63, 63)
                                                        .addComponent(cancelBtn)))
                                        .addContainerGap(11, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(createNewInvoiceFormeL)
                                .addGap(0, 165, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(customerNameCrInL)
                                                .addComponent(customerNameCrInF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(dateCrInL)
                                                .addComponent(dateCrInF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(okBtn)
                                                .addComponent(cancelBtn))
                                        .addGap(25, 25, 25)))
        );

        pack();

    }

    public JTextField getCustNameField() {
        return customerNameCrInF;
    }

    public JTextField getInvDateField() {
        return dateCrInF;
    }
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel createNewInvoiceFormeL;
    public static javax.swing.JTextField customerNameCrInF;
    private javax.swing.JLabel customerNameCrInL;
    private javax.swing.JTextField dateCrInF;
    private javax.swing.JLabel dateCrInL;
    private javax.swing.JButton okBtn;

}
