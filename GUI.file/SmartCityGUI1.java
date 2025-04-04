/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smartcity.GUI;

/**
 *
 * @author zachchiu
 */
public class SmartCityGUI1 extends javax.swing.JFrame {

    /**
     * Creates new form SmartCityGUI1
     */
    public SmartCityGUI1() {
        initComponents();
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
        alertMessageInput = new javax.swing.JTextField();
        checkPollutionButton = new javax.swing.JButton();
        sendAlertButton = new javax.swing.JButton();
        airQualityLocationInput = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        parkingLocationInput = new javax.swing.JTextField();
        findParkingButton = new javax.swing.JButton();
        userIdInput = new javax.swing.JTextField();
        reserveSpotButton = new javax.swing.JButton();
        spotIdInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        parkingOutput = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        accidentLocationInput = new javax.swing.JTextField();
        notifyEmergencyButton = new javax.swing.JButton();
        teamIdInput = new javax.swing.JTextField();
        reportAccidentButton = new javax.swing.JButton();
        accidentSeverityInput = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        emergencyOutput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart City Automation System");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alertMessageInput.setText("Alter message");
        alertMessageInput.setName(""); // NOI18N
        alertMessageInput.setPreferredSize(new java.awt.Dimension(200, 50));
        alertMessageInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alertMessageInputActionPerformed(evt);
            }
        });
        jPanel1.add(alertMessageInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 60));

        checkPollutionButton.setText("Check Pollution");
        checkPollutionButton.setName(""); // NOI18N
        checkPollutionButton.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel1.add(checkPollutionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        sendAlertButton.setText("Send Alter");
        sendAlertButton.setName(""); // NOI18N
        sendAlertButton.setPreferredSize(new java.awt.Dimension(120, 30));
        sendAlertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendAlertButtonActionPerformed(evt);
            }
        });
        jPanel1.add(sendAlertButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        airQualityLocationInput.setText("Location Input");
        airQualityLocationInput.setPreferredSize(new java.awt.Dimension(200, 30));
        airQualityLocationInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airQualityLocationInputActionPerformed(evt);
            }
        });
        jPanel1.add(airQualityLocationInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName(""); // NOI18N
        jTextArea1.setPreferredSize(new java.awt.Dimension(232, 100));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 240, 120));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        parkingLocationInput.setText("Location Input");
        parkingLocationInput.setName(""); // NOI18N
        parkingLocationInput.setPreferredSize(new java.awt.Dimension(150, 23));
        parkingLocationInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parkingLocationInputActionPerformed(evt);
            }
        });
        jPanel2.add(parkingLocationInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        findParkingButton.setText("Find Parking");
        findParkingButton.setName(""); // NOI18N
        findParkingButton.setPreferredSize(new java.awt.Dimension(120, 30));
        findParkingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findParkingButtonActionPerformed(evt);
            }
        });
        jPanel2.add(findParkingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 130, -1));

        userIdInput.setEditable(false);
        userIdInput.setText("User ID");
        jPanel2.add(userIdInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 30));

        reserveSpotButton.setText("Reserve Spot  ");
        jPanel2.add(reserveSpotButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 130, 30));

        spotIdInput.setText("Spot ID");
        jPanel2.add(spotIdInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 30));

        parkingOutput.setEditable(false);
        parkingOutput.setColumns(20);
        parkingOutput.setRows(5);
        jScrollPane1.setViewportView(parkingOutput);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 240, 130));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accidentLocationInput.setText("Location Input");
        accidentLocationInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accidentLocationInputActionPerformed(evt);
            }
        });
        jPanel3.add(accidentLocationInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        notifyEmergencyButton.setText("NotifyEmergencyTeam");
        notifyEmergencyButton.setPreferredSize(new java.awt.Dimension(120, 30));
        notifyEmergencyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifyEmergencyButtonActionPerformed(evt);
            }
        });
        jPanel3.add(notifyEmergencyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 170, -1));

        teamIdInput.setText("Team ID");
        teamIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamIdInputActionPerformed(evt);
            }
        });
        jPanel3.add(teamIdInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 180, 30));

        reportAccidentButton.setText("Report");
        reportAccidentButton.setPreferredSize(new java.awt.Dimension(120, 30));
        reportAccidentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportAccidentButtonActionPerformed(evt);
            }
        });
        jPanel3.add(reportAccidentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 130, -1));

        accidentSeverityInput.setText("Accident serverity Input");
        jPanel3.add(accidentSeverityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 30));

        emergencyOutput.setEditable(false);
        emergencyOutput.setColumns(20);
        emergencyOutput.setRows(5);
        jScrollPane3.setViewportView(emergencyOutput);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parkingLocationInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parkingLocationInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parkingLocationInputActionPerformed

    private void findParkingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findParkingButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findParkingButtonActionPerformed

    private void reportAccidentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportAccidentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportAccidentButtonActionPerformed

    private void teamIdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamIdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamIdInputActionPerformed

    private void alertMessageInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alertMessageInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alertMessageInputActionPerformed

    private void sendAlertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendAlertButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendAlertButtonActionPerformed

    private void notifyEmergencyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifyEmergencyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notifyEmergencyButtonActionPerformed

    private void accidentLocationInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accidentLocationInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accidentLocationInputActionPerformed

    private void airQualityLocationInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airQualityLocationInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airQualityLocationInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SmartCityGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SmartCityGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SmartCityGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SmartCityGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartCityGUI1().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accidentLocationInput;
    private javax.swing.JTextField accidentSeverityInput;
    private javax.swing.JTextField airQualityLocationInput;
    private javax.swing.JTextField alertMessageInput;
    private javax.swing.JButton checkPollutionButton;
    private javax.swing.JTextArea emergencyOutput;
    private javax.swing.JButton findParkingButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton notifyEmergencyButton;
    private javax.swing.JTextField parkingLocationInput;
    private javax.swing.JTextArea parkingOutput;
    private javax.swing.JButton reportAccidentButton;
    private javax.swing.JButton reserveSpotButton;
    private javax.swing.JButton sendAlertButton;
    private javax.swing.JTextField spotIdInput;
    private javax.swing.JTextField teamIdInput;
    private javax.swing.JTextField userIdInput;
    // End of variables declaration//GEN-END:variables

}
