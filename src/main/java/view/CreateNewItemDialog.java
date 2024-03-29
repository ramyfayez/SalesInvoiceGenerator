package view;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class CreateNewItemDialog extends JDialog {
    public CreateNewItemDialog(InvoiceFrame frame) {
        JLabel itemNameCrL = new JLabel();
        JLabel itemCountCrL = new JLabel();
        JLabel itemPriceCrL = new JLabel();
        itemNameCrF = new javax.swing.JTextField();
        itemCountCrF = new javax.swing.JTextField();
        itemPriceCrF = new javax.swing.JFormattedTextField();
        JButton itemOkBtn = new JButton();
        // Variables declaration - do not modify
        JButton itemCancelBtn = new JButton();

        itemCountCrF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (( ( c < '0' ) || ( c > '9' ) ) && ( c != KeyEvent.VK_BACK_SPACE )) {
                    e.consume();
                }
            }
        });


        itemNameCrL.setText("*Item Name");

        itemCountCrL.setText("*Item Count");

        itemPriceCrL.setText("*Item Price");

        itemOkBtn.setText("Ok");
        itemCancelBtn.setText("Cancel");

        itemOkBtn.setActionCommand("newItemOKBtn");
        itemCancelBtn.setActionCommand("newItemCancelBtn");

        itemOkBtn.addActionListener(frame.getHandler());
        itemCancelBtn.addActionListener(frame.getHandler());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(itemNameCrL, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemNameCrF))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(itemPriceCrL, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemPriceCrF))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(itemCountCrL, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemCountCrF)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(itemOkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(itemCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemNameCrL)
                                        .addComponent(itemNameCrF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemCountCrF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemCountCrL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemPriceCrL)
                                        .addComponent(itemPriceCrF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(itemOkBtn)
                                        .addComponent(itemCancelBtn))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }

    public JTextField getItemNameField() {
        return itemNameCrF;
    }

    public JTextField getItemCountField() {
        return itemCountCrF;
    }

    public JTextField getItemPriceField() {
        return itemPriceCrF;
    }

    public static javax.swing.JTextField itemCountCrF;
    public static javax.swing.JTextField itemNameCrF;
    public static javax.swing.JFormattedTextField itemPriceCrF;
}
