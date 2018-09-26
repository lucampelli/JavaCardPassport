/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import util.FingerPrintVerification;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.CardException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import myjmrtdcardapplication.CardReader;
import org.bouncycastle.util.Arrays;
import org.jmrtd.BACKey;
import org.jmrtd.lds.LDSFile;
import org.jmrtd.lds.SODFile;
import org.jmrtd.lds.icao.COMFile;
import org.jmrtd.lds.icao.MRZInfo;
import org.jmrtd.lds.iso19794.FingerInfo;
import util.CardConnection;
import util.ControlledDialog;
import util.GlobalFlags;

/**
 *
 * @author luca
 */
public class VerifyPanel extends javax.swing.JPanel implements Runnable {

    private JFrame container;
    public String DOCUMENTNUMBER = ""; //"123456789"; //RG - requerido 9digitos
    public String DATEOFBIRTH = "";//150831"; // requerido - yymmdd
    public String DATEOFEXPIRY = "";//150831"; // gerado
    private BufferedImage picture;
    Thread readThread;
    private boolean isReading = false;
    private FingerInfo[] fingers;

    /**
     * Creates new form VerifyPanel
     */
    public VerifyPanel(JFrame container) {
        initComponents();

        this.container = container;

        new BACFrame(this);

        container.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                Graphics g = jPanel1.getGraphics();
                if (g == null) {
                    System.out.println("Image Error");
                    return;
                }
                g.fillRect(0, 0, 150, 200);
                g.drawImage(picture, 0, 0, 150, 200, jPanel1);

            }

        });
        
        fingers = new FingerInfo[10];

    }

    protected void set(String DocNum, String birth, String exp) {
        this.DOCUMENTNUMBER = DocNum;
        this.DATEOFBIRTH = birth;
        this.DATEOFEXPIRY = exp;

        readThread = new Thread(this);
        readThread.start();

    }

    //Check ComFile e ver o que tem nele em vez de checar no método read
    public void run() {
        try {
            isReading = true;
            container.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            CardReader reader = new CardReader();
            BACKey key = new BACKey(DOCUMENTNUMBER, DATEOFBIRTH, DATEOFEXPIRY);

            reader.doBAC(key);

            COMFile com = reader.readCOM();            
            
            for(int i : com.getTagList()){
                System.out.println(i);
            }

            SODFile sod = reader.readSOD();

            if (Arrays.contains(com.getTagList(), LDSFile.EF_DG1_TAG)) {
                MRZInfo info = reader.readDG1();

                DocNumLabel.setText(info.getDocumentNumber());
                NameLabel.setText(info.getSecondaryIdentifier().replace("<", " "));
                SurLabel.setText(info.getPrimaryIdentifier().replace("<", " "));
                SexLabel.setText(info.getGender().toString());
                NascLabel.setText(info.getNationality());
                EmitLabel.setText(info.getIssuingState());

                BirthLabel.setText(formatDateUStoW(info.getDateOfBirth()));  //<<Formatar
                ExpiryLabel.setText(formatDateUStoW(info.getDateOfExpiry()));

                CPFLabel.setText(info.getPersonalNumber());

            }
            if (Arrays.contains(com.getTagList(), LDSFile.EF_DG2_TAG)) {
                picture = reader.readDG2();
            }
            /*
            if (Arrays.contains(com.getTagList(), LDSFile.EF_DG3_TAG)) {
                for(FingerInfo f : reader.readDG3()){
                    System.out.println(f.getFingerImageInfos().get(0).getPosition());
                    if(f.getFingerImageInfos().get(0).getPosition() != 0){
                        fingers[f.getFingerImageInfos().get(0).getPosition() -1] = f;
                    }
                }
            }
            */
            reader.executeSecurityProtocols(com, sod);

            System.out.println(sod);

            JOptionPane.showMessageDialog(null, "Finished");

            container.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            isReading = false;

        } catch (Exception ex) {
            Logger.getLogger(VerifyPanel.class.getName()).log(Level.SEVERE, null, ex);
            isReading = false;
            MainPanel.needsReset = true;
            JOptionPane.showMessageDialog(null, "Error de leitura:" + System.lineSeparator() + ex.getMessage());
            //container.dispose();
            container.repaint();
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SurLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BirthLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NascLabel = new javax.swing.JLabel();
        EmitLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ExpiryLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SexLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CPFLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DocNumLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel1.setText("Nome:");

        NameLabel.setText("jLabel2");

        jLabel2.setText("Sobrenome:");

        SurLabel.setText("jLabel3");

        jLabel3.setText("Data de Nascimento:");

        BirthLabel.setText("jLabel4");

        jLabel4.setText("Nascionalidade:");

        jLabel5.setText("Estado Emissor:");

        NascLabel.setText("jLabel6");

        EmitLabel.setText("jLabel6");

        jLabel6.setText("Valido ate:");

        ExpiryLabel.setText("jLabel7");

        jLabel7.setText("Genero:");

        SexLabel.setText("jLabel8");

        jLabel8.setText("CPF:");

        CPFLabel.setText("jLabel9");

        jLabel9.setText("Numero do Passaporte:");

        DocNumLabel.setText("jLabel10");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Conferir Digitais");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(ExpiryLabel)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(NameLabel)
                            .addComponent(jLabel2)
                            .addComponent(SurLabel)
                            .addComponent(jLabel3)
                            .addComponent(BirthLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(SexLabel))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DocNumLabel)
                                    .addComponent(jLabel9)))
                            .addComponent(CPFLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(NascLabel))
                                .addGap(114, 114, 114)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmitLabel)
                                    .addComponent(jLabel5))))
                        .addContainerGap(84, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SurLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BirthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NascLabel)
                            .addComponent(EmitLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExpiryLabel)
                    .addComponent(SexLabel)
                    .addComponent(DocNumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPFLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!isReading) {
            this.container.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!isReading) {
            this.container.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new FingerPrintVerification(fingers);
    }//GEN-LAST:event_jButton3ActionPerformed

    public void close() {
        if (!isReading) {
            this.container.dispose();
        }
    }

    private String formatDateUStoW(String yymmdd) {
        String res = "";
        Calendar cal = Calendar.getInstance();

        String year = yymmdd.substring(0, 2);
        String month = yymmdd.substring(2, 4);
        String day = yymmdd.substring(4);
        if (Integer.parseInt(year) > cal.get(Calendar.YEAR) - 1950) {
            year = "19" + year;
        } else {
            year = "20" + year;
        }

        return day + " / " + month + " / " + year;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BirthLabel;
    private javax.swing.JLabel CPFLabel;
    private javax.swing.JLabel DocNumLabel;
    private javax.swing.JLabel EmitLabel;
    private javax.swing.JLabel ExpiryLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel NascLabel;
    private javax.swing.JLabel SexLabel;
    private javax.swing.JLabel SurLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
