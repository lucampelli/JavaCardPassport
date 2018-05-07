/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JComboBox;

/**
 *
 * @author luca
 */
public class BACFrame extends javax.swing.JFrame {

    VerifyPanel parent;
    HashMap<Integer,Integer> daysMonths;

    /**
     * Creates new form BACFrame
     */
    public BACFrame(VerifyPanel parent) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("BAC Entry");
        
        this.parent = parent;
        
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                
            }
        });
        
        this.daysMonths = new HashMap();
        daysMonths.put(1, 31);
        daysMonths.put(2, 28);
        daysMonths.put(3, 31);
        daysMonths.put(4, 30);
        daysMonths.put(5, 31);
        daysMonths.put(6, 30);
        daysMonths.put(7, 31);
        daysMonths.put(8, 31);
        daysMonths.put(9, 30);
        daysMonths.put(10, 31);
        daysMonths.put(11, 30);
        daysMonths.put(12, 31);

        Calendar cal = Calendar.getInstance();

        BIRTHMONTHBOX.removeAllItems();
        for (int i = 0; i < this.getMonths().length; i++) {
            BIRTHMONTHBOX.addItem(this.getMonths()[i]);
        }
        BIRTHMONTHBOX.setSelectedIndex(cal.get(Calendar.MONTH));

        BIRTHDAYBOX.setSelectedIndex(cal.get(Calendar.DATE)-1);

        BIRTHYEARBOX.removeAllItems();
        for (int i = 0; i <= 100; i++) {
            BIRTHYEARBOX.addItem((cal.get(Calendar.YEAR) - i) + "");
        }
        
        EXPMONTHBOX.removeAllItems();
        for (int i = 0; i < this.getMonths().length; i++) {
            EXPMONTHBOX.addItem(this.getMonths()[i]);
        }
        EXPMONTHBOX.setSelectedIndex(cal.get(Calendar.MONTH));

        EXPDAYBOX.setSelectedIndex(cal.get(Calendar.DATE)-1);

        EXPYEARBOX.removeAllItems();
        for (int i = -10; i <= 90; i++) {
            EXPYEARBOX.addItem((cal.get(Calendar.YEAR) - i) + "");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        DOCNUMFIELD = new javax.swing.JTextField();
        BIRTHDAYBOX = new javax.swing.JComboBox<>();
        BIRTHMONTHBOX = new javax.swing.JComboBox<>();
        BIRTHYEARBOX = new javax.swing.JComboBox<>();
        EXPDAYBOX = new javax.swing.JComboBox<>();
        EXPMONTHBOX = new javax.swing.JComboBox<>();
        EXPYEARBOX = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Document Number:");

        jLabel2.setText("Date of Birth");

        jLabel3.setText("Date of Expiry:");

        OkButton.setText("OK");
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        DOCNUMFIELD.setText("123456789");
        DOCNUMFIELD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOCNUMFIELDActionPerformed(evt);
            }
        });

        BIRTHDAYBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BIRTHDAYBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIRTHDAYBOXActionPerformed(evt);
            }
        });

        BIRTHMONTHBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BIRTHMONTHBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIRTHMONTHBOXActionPerformed(evt);
            }
        });

        BIRTHYEARBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EXPDAYBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EXPMONTHBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EXPMONTHBOX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXPMONTHBOXActionPerformed(evt);
            }
        });

        EXPYEARBOX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DOCNUMFIELD))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BIRTHDAYBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BIRTHMONTHBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BIRTHYEARBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EXPDAYBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EXPMONTHBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EXPYEARBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(DOCNUMFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BIRTHDAYBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BIRTHMONTHBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BIRTHYEARBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EXPDAYBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXPMONTHBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXPYEARBOX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        String DocNum = "";
        String birth = "";
        String exp = "";
        String errMsg = "";
        
        DocNum = DOCNUMFIELD.getText().trim();
        if(DocNum.length() != 9){
            errMsg += "Wrong Document Number Length!" + System.lineSeparator();
        }
        if(!DocNum.matches("[0-9]+")){
            errMsg += "Document Number Can't Have Letters";
        }
        
        birth = BIRTHYEARBOX.getItemAt(BIRTHYEARBOX.getSelectedIndex()).substring(2);
        birth += ((BIRTHMONTHBOX.getSelectedIndex()+1) <= 9 ? "0" + (BIRTHMONTHBOX.getSelectedIndex()+1) : (BIRTHMONTHBOX.getSelectedIndex()+1));
        birth += ((BIRTHDAYBOX.getSelectedIndex()+1) <= 9 ? "0" + (BIRTHDAYBOX.getSelectedIndex()+1) : (BIRTHDAYBOX.getSelectedIndex()+1));
        
        exp = EXPYEARBOX.getItemAt(EXPYEARBOX.getSelectedIndex()).substring(2);
        exp += ((EXPMONTHBOX.getSelectedIndex()+1) <= 9 ? "0" + (EXPMONTHBOX.getSelectedIndex()+1) : (EXPMONTHBOX.getSelectedIndex()+1));
        exp += ((EXPDAYBOX.getSelectedIndex()+1) <= 9 ? "0" + (EXPDAYBOX.getSelectedIndex()+1) : (EXPDAYBOX.getSelectedIndex()+1));
        
        System.out.println(DocNum);
        System.out.println(birth);
        System.out.println(exp);
        
        if(!errMsg.isEmpty()){
            System.out.println(errMsg);
            return;
        }
        
        parent.set(DocNum, birth, exp);
        dispose();
    }//GEN-LAST:event_OkButtonActionPerformed

    private void BIRTHDAYBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIRTHDAYBOXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BIRTHDAYBOXActionPerformed

    private void BIRTHMONTHBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIRTHMONTHBOXActionPerformed
        
        int dia = BIRTHDAYBOX.getSelectedIndex();
        BIRTHDAYBOX.removeAllItems();
        for (int i = 1; i <= this.getDays(BIRTHMONTHBOX); i++) {
            BIRTHDAYBOX.addItem(i + "");
        }
        
        if(dia > BIRTHDAYBOX.getItemCount()-1){
            BIRTHDAYBOX.setSelectedIndex(BIRTHDAYBOX.getItemCount() -1);
        } else {
            BIRTHDAYBOX.setSelectedIndex(dia);
        }
    }//GEN-LAST:event_BIRTHMONTHBOXActionPerformed

    private void EXPMONTHBOXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXPMONTHBOXActionPerformed
        
        int dia = EXPDAYBOX.getSelectedIndex();
        EXPDAYBOX.removeAllItems();
        for (int i = 1; i <= this.getDays(EXPMONTHBOX); i++) {
            EXPDAYBOX.addItem(i + "");
        }
        
        if(dia > EXPDAYBOX.getItemCount()-1){
            EXPDAYBOX.setSelectedIndex(EXPDAYBOX.getItemCount() -1);
        } else {
            EXPDAYBOX.setSelectedIndex(dia);
        }
    }//GEN-LAST:event_EXPMONTHBOXActionPerformed

    private void DOCNUMFIELDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOCNUMFIELDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOCNUMFIELDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        parent.close();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private int getDays(JComboBox<String> box) {
        int choice = box.getSelectedIndex();
        if (choice < 0) {
            choice = 0;
        }
        return daysMonths.get(choice + 1);
    }

    private String[] getMonths() {
        String[] temp = new java.text.DateFormatSymbols().getMonths();
        if (temp[temp.length - 1].equals("")) {
            String[] ret = new String[temp.length - 1];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = temp[i];
            }
            return ret;
        }
        return temp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BIRTHDAYBOX;
    private javax.swing.JComboBox<String> BIRTHMONTHBOX;
    private javax.swing.JComboBox<String> BIRTHYEARBOX;
    private javax.swing.JTextField DOCNUMFIELD;
    private javax.swing.JComboBox<String> EXPDAYBOX;
    private javax.swing.JComboBox<String> EXPMONTHBOX;
    private javax.swing.JComboBox<String> EXPYEARBOX;
    private javax.swing.JButton OkButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
