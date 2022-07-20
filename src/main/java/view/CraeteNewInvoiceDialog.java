package view;

import javax.swing.*;


public class CraeteNewInvoiceDialog extends JDialog {

    public CraeteNewInvoiceDialog(InvoiceFrame frame) {
        JLabel createNewInvoiceFormeL = new JLabel();
        JLabel customerNameCrInL = new JLabel();
        customerNameCrInF = new javax.swing.JTextField();
        JLabel dateCrInL = new JLabel();
        dateCrInF = new javax.swing.JTextField();
        JButton okBtn = new JButton();
        JButton cancelBtn = new JButton();


        customerNameCrInL.setText("*Customer Name");

        dateCrInL.setText("*Date");

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

    public static javax.swing.JTextField customerNameCrInF;
    public static javax.swing.JTextField dateCrInF;

}
