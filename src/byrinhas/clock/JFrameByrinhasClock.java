package byrinhas.clock;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class JFrameByrinhasClock extends javax.swing.JFrame implements Runnable {

    //          :::::::::: ALARME ::::::::::
    //
    // ALGUMAS VARIAVEIS DE ALARME:
    boolean alarmStatus;
    int alarmHour, alarmMinutes;

    // METODO QUE LIMPA OS CAMPOS DE TEXTO:
    public void limpaCampos() {

        jSpinnerAlarmHour.setValue("08");
        jSpinnerAlarmMinutes.setValue("00");
    }

    // METODO QUE ATIVA O ALARME:
    public void setAlarmOK() {

        try {
            alarmHour = Integer.parseInt(jSpinnerAlarmHour.getValue().toString());
            alarmMinutes = Integer.parseInt(jSpinnerAlarmMinutes.getValue().toString());
            jLabelAlarmSetTo.setForeground(Color.GREEN);
            jLabelAlarmSetTo.setText("set to: " + alarmHour + ":" + alarmMinutes);
            alarmStatus = true;
            limpaCampos();

        } catch (Exception setAlarmOKError) {
            JOptionPane.showMessageDialog(null, "setAlarmOK(){} error.");
        }
    }

    // METODO QUE DESATIVA O ALARME:
    public void setAlarmOFF() {

        String alarmOFF = "Alarm: { OFF } ";

        try {
            jLabelAlarmSetTo.setForeground(Color.RED);
            jLabelAlarmSetTo.setText(alarmOFF);
            jLabelAlarmSetTo.setText(alarmOFF);
            alarmStatus = false;
            limpaCampos();

        } catch (Exception setAlarmOFFError) {
            JOptionPane.showMessageDialog(null, "setAlarmOFF(){} error.");
        }
    }

    //          :::::::::: RELOGIO ::::::::::
    //
    // ALGUMAS VARIAVEIS DE RELOGIO:
    int clockHour, clockMinutes, clockSeconds;
    String currentTime;

    // RUN:
    @Override
    public void run() {
        while (true) {
            try {
                // SETANDO A DATA:
                SimpleDateFormat sdfCurrentDate = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date(System.currentTimeMillis());
                jLabelSetDate.setText(sdfCurrentDate.format(date));

                // SETANDO A HORA ATUAL:
                Calendar calendar = Calendar.getInstance();
                int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                int currentMinutes = calendar.get(Calendar.MINUTE);
                int currentSeconds = calendar.get(Calendar.SECOND);

                // SETANDO A HORA DO RELOGIO:
                clockHour = currentHour;
                clockMinutes = currentMinutes;
                clockSeconds = currentSeconds;

                SimpleDateFormat sdfCurrentTime = new SimpleDateFormat("HH:mm:ss");

                Date time = calendar.getTime();
                currentTime = sdfCurrentTime.format(time);
                jLabelSetTime.setText(currentTime);

                // FAZENDO O ALARME TOCAR:
                if (alarmStatus == true) {
                    try {
                        if (alarmHour == currentHour && alarmMinutes == currentMinutes) {
                            JOptionPane.showMessageDialog(null, "Acorda Bylinha!!!");
                            setAlarmOFF();
                        }

                    } catch (Exception alarmTriggerError) {
                        JOptionPane.showMessageDialog(null, "alarmTrigger error.");
                    }
                }

            } catch (Exception runError) {
                JOptionPane.showMessageDialog(null, "run(){} error: " + runError);
            }
        }
    }

    // CONSTRUTOR:
    public JFrameByrinhasClock() {

        initComponents();

        Thread thread = new Thread(this);
        thread.start();

        setAlarmOFF();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelByrinhasAlarm = new javax.swing.JLabel();
        jLabelSetAlarm = new javax.swing.JLabel();
        jLabelHorasDoubleDote1 = new javax.swing.JLabel();
        jButtonCancelSet = new javax.swing.JButton();
        jLabelAlarmStatus = new javax.swing.JLabel();
        jButtonSetAlarm = new javax.swing.JButton();
        jLabelAlarmSetTo = new javax.swing.JLabel();
        jSpinnerAlarmHour = new javax.swing.JSpinner();
        jSpinnerAlarmMinutes = new javax.swing.JSpinner();
        jLabelByrinhasClock = new javax.swing.JLabel();
        jLabelHoras = new javax.swing.JLabel();
        jLabelSetTime = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelSetDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Byrinha's clock (^~^)");
        setBackground(java.awt.Color.darkGray);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setForeground(java.awt.Color.gray);
        jPanel2.setPreferredSize(new java.awt.Dimension(380, 80));

        jLabelByrinhasAlarm.setBackground(java.awt.Color.darkGray);
        jLabelByrinhasAlarm.setFont(new java.awt.Font("Serif", 1, 19)); // NOI18N
        jLabelByrinhasAlarm.setForeground(java.awt.Color.darkGray);
        jLabelByrinhasAlarm.setText("Byrinha's alarm");

        jLabelSetAlarm.setBackground(java.awt.Color.darkGray);
        jLabelSetAlarm.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelSetAlarm.setForeground(java.awt.Color.darkGray);
        jLabelSetAlarm.setText("Set alarm >>");

        jLabelHorasDoubleDote1.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelHorasDoubleDote1.setForeground(java.awt.Color.darkGray);
        jLabelHorasDoubleDote1.setText("::");

        jButtonCancelSet.setBackground(java.awt.Color.darkGray);
        jButtonCancelSet.setFont(new java.awt.Font("Serif", 1, 10)); // NOI18N
        jButtonCancelSet.setForeground(java.awt.Color.yellow);
        jButtonCancelSet.setText("Cancel");
        jButtonCancelSet.setMaximumSize(new java.awt.Dimension(90, 18));
        jButtonCancelSet.setMinimumSize(new java.awt.Dimension(90, 18));
        jButtonCancelSet.setPreferredSize(new java.awt.Dimension(90, 18));
        jButtonCancelSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelSetActionPerformed(evt);
            }
        });

        jLabelAlarmStatus.setBackground(java.awt.Color.darkGray);
        jLabelAlarmStatus.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelAlarmStatus.setForeground(java.awt.Color.darkGray);
        jLabelAlarmStatus.setText("Alarm status:");

        jButtonSetAlarm.setBackground(java.awt.Color.darkGray);
        jButtonSetAlarm.setFont(new java.awt.Font("Serif", 1, 10)); // NOI18N
        jButtonSetAlarm.setForeground(java.awt.Color.cyan);
        jButtonSetAlarm.setText("OK");
        jButtonSetAlarm.setMaximumSize(new java.awt.Dimension(60, 18));
        jButtonSetAlarm.setMinimumSize(new java.awt.Dimension(60, 18));
        jButtonSetAlarm.setPreferredSize(new java.awt.Dimension(60, 18));
        jButtonSetAlarm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSetAlarmMouseClicked(evt);
            }
        });
        jButtonSetAlarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetAlarmActionPerformed(evt);
            }
        });

        jLabelAlarmSetTo.setBackground(java.awt.Color.green);
        jLabelAlarmSetTo.setFont(new java.awt.Font("Serif", 1, 10)); // NOI18N
        jLabelAlarmSetTo.setForeground(java.awt.Color.red);
        jLabelAlarmSetTo.setText("{ . . . }");
        jLabelAlarmSetTo.setMaximumSize(new java.awt.Dimension(126, 16));
        jLabelAlarmSetTo.setMinimumSize(new java.awt.Dimension(35, 16));
        jLabelAlarmSetTo.setPreferredSize(new java.awt.Dimension(66, 16));
        jLabelAlarmSetTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAlarmSetToMouseClicked(evt);
            }
        });

        jSpinnerAlarmHour.setFont(new java.awt.Font("Serif", 1, 10)); // NOI18N
        jSpinnerAlarmHour.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        jSpinnerAlarmHour.setMinimumSize(new java.awt.Dimension(44, 22));
        jSpinnerAlarmHour.setPreferredSize(new java.awt.Dimension(44, 22));
        jSpinnerAlarmHour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinnerAlarmHourMouseClicked(evt);
            }
        });

        jSpinnerAlarmMinutes.setFont(new java.awt.Font("Serif", 1, 10)); // NOI18N
        jSpinnerAlarmMinutes.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        jSpinnerAlarmMinutes.setMinimumSize(new java.awt.Dimension(44, 22));
        jSpinnerAlarmMinutes.setPreferredSize(new java.awt.Dimension(44, 22));
        jSpinnerAlarmMinutes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSpinnerAlarmMinutesMouseClicked(evt);
            }
        });

        jLabelByrinhasClock.setBackground(java.awt.Color.darkGray);
        jLabelByrinhasClock.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelByrinhasClock.setForeground(java.awt.Color.darkGray);
        jLabelByrinhasClock.setText("Byrinha's clock");

        jLabelHoras.setBackground(java.awt.Color.darkGray);
        jLabelHoras.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelHoras.setForeground(java.awt.Color.darkGray);
        jLabelHoras.setText("Hora:");

        jLabelSetTime.setBackground(java.awt.Color.cyan);
        jLabelSetTime.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelSetTime.setForeground(java.awt.Color.cyan);
        jLabelSetTime.setText("Horas");
        jLabelSetTime.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabelSetTime.setMinimumSize(new java.awt.Dimension(33, 22));
        jLabelSetTime.setPreferredSize(new java.awt.Dimension(75, 22));

        jLabelData.setBackground(java.awt.Color.darkGray);
        jLabelData.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelData.setForeground(java.awt.Color.darkGray);
        jLabelData.setText("Data:");

        jLabelSetDate.setBackground(java.awt.Color.cyan);
        jLabelSetDate.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelSetDate.setForeground(java.awt.Color.cyan);
        jLabelSetDate.setText("Data");
        jLabelSetDate.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabelSetDate.setPreferredSize(new java.awt.Dimension(75, 22));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelByrinhasAlarm)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelByrinhasClock)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addComponent(jLabelHoras)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelSetAlarm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerAlarmHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHorasDoubleDote1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerAlarmMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSetAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabelAlarmStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAlarmSetTo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelByrinhasClock)
                    .addComponent(jLabelHoras)
                    .addComponent(jLabelSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelData)
                    .addComponent(jLabelSetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelByrinhasAlarm)
                    .addComponent(jLabelAlarmStatus)
                    .addComponent(jLabelAlarmSetTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSetAlarm)
                    .addComponent(jSpinnerAlarmHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorasDoubleDote1)
                    .addComponent(jSpinnerAlarmMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSetAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseReleased

    // BOTAO CANCEL:
    private void jButtonCancelSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelSetActionPerformed
        // TODO add your handling code here:
        setAlarmOFF();
    }//GEN-LAST:event_jButtonCancelSetActionPerformed

    // BOTAO OK:
    private void jButtonSetAlarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetAlarmActionPerformed
        // TODO add your handling code here:
        setAlarmOK();
    }//GEN-LAST:event_jButtonSetAlarmActionPerformed

    private void jButtonSetAlarmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSetAlarmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSetAlarmMouseClicked

    private void jLabelAlarmSetToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAlarmSetToMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelAlarmSetToMouseClicked

    private void jSpinnerAlarmHourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerAlarmHourMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinnerAlarmHourMouseClicked

    private void jSpinnerAlarmMinutesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerAlarmMinutesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinnerAlarmMinutesMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameByrinhasClock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelSet;
    private javax.swing.JButton jButtonSetAlarm;
    private javax.swing.JLabel jLabelAlarmSetTo;
    private javax.swing.JLabel jLabelAlarmStatus;
    private javax.swing.JLabel jLabelByrinhasAlarm;
    private javax.swing.JLabel jLabelByrinhasClock;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHoras;
    private javax.swing.JLabel jLabelHorasDoubleDote1;
    private javax.swing.JLabel jLabelSetAlarm;
    private javax.swing.JLabel jLabelSetDate;
    private javax.swing.JLabel jLabelSetTime;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinnerAlarmHour;
    private javax.swing.JSpinner jSpinnerAlarmMinutes;
    // End of variables declaration//GEN-END:variables
}
