package byrinhas.clock;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class JFrameByrinhasClock extends javax.swing.JFrame implements Runnable {

    // ALGUMAS VARIAVEIS DE ALARME:   
    boolean alarmStatus;
    String textAlarmStatus;
    int hora, minuto;

    // METODO QUE ATIVA O ALARME:
    public void setAlarmOK() {

        try {
            hora = Integer.parseInt(jTextFieldHour.getText());
            minuto = Integer.parseInt(jTextFieldMinutes.getText());
            jLabelAlarm.setText("Alarm: " + hora + ":" + minuto);
            jLabelSetStatus.setForeground(Color.GREEN);
            textAlarmStatus = "Alarm: { ON } ";
            jLabelSetStatus.setText(textAlarmStatus);
            alarmStatus = true;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Horario incompativel.");
        }
    }

    // METODO QUE DESATIVA O ALARME:
    public void setAlarmOFF() {

        jLabelSetStatus.setForeground(Color.RED);
        textAlarmStatus = "Alarm: { OFF } ";
        jLabelSetStatus.setText(textAlarmStatus);
        String textEmpityAlarmStatus = "{ . . . }";
        jLabelAlarm.setText(textEmpityAlarmStatus);
        alarmStatus = false;
    }

    // ALGUMAS VARIAVEIS DE HORA:
    private int hour, minutes, seconds;
    private String timestr;

    // RUN:
    @Override
    public void run() {

        while (true) {
            try {
                // SETANDO A HORA:
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minutes = calendar.get(Calendar.MINUTE);
                seconds = calendar.get(Calendar.SECOND);

                SimpleDateFormat sdfCurrentTime = new SimpleDateFormat("hh:mm:ss");

                Date date = calendar.getTime();
                timestr = sdfCurrentTime.format(date);
                jLabelSetTime.setText(timestr);

            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Run: " + error);
            }
        }
    }

    // CONSTRUTOR:
    public JFrameByrinhasClock() {

        initComponents();

        // DATA:
        SimpleDateFormat sdfCurrentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        jLabelSetDate.setText(sdfCurrentDate.format(date));

        Thread thread = new Thread(this);
        thread.start();

        // ALARME:
        alarmStatus = false;
        textAlarmStatus = "Alarm: { OFF } ";
        jLabelSetStatus.setText(textAlarmStatus);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelByrinhasClock = new javax.swing.JLabel();
        jLabelHoras = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelSetTime = new javax.swing.JLabel();
        jLabelSetDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelByrinhasAlarm = new javax.swing.JLabel();
        jLabelSetAlarm = new javax.swing.JLabel();
        jTextFieldHour = new javax.swing.JTextField();
        jTextFieldMinutes = new javax.swing.JTextField();
        jLabelHorasDoubleDote1 = new javax.swing.JLabel();
        jLabelHorasDoubleDote2 = new javax.swing.JLabel();
        jButtonCancelSet = new javax.swing.JButton();
        jLabelAlarmStatus = new javax.swing.JLabel();
        jButtonSetAlarm = new javax.swing.JButton();
        jLabelSetStatus = new javax.swing.JLabel();
        jLabelAlarm = new javax.swing.JLabel();

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

        jPanel1.setBackground(java.awt.Color.gray);
        jPanel1.setForeground(java.awt.Color.gray);
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 80));

        jLabelByrinhasClock.setBackground(java.awt.Color.darkGray);
        jLabelByrinhasClock.setFont(new java.awt.Font("Serif", 1, 19)); // NOI18N
        jLabelByrinhasClock.setForeground(java.awt.Color.darkGray);
        jLabelByrinhasClock.setText("Byrinha's clock");

        jLabelHoras.setBackground(java.awt.Color.darkGray);
        jLabelHoras.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelHoras.setForeground(java.awt.Color.darkGray);
        jLabelHoras.setText("Hora:");

        jLabelData.setBackground(java.awt.Color.darkGray);
        jLabelData.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelData.setForeground(java.awt.Color.darkGray);
        jLabelData.setText("Data:");

        jLabelSetTime.setBackground(java.awt.Color.cyan);
        jLabelSetTime.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelSetTime.setForeground(java.awt.Color.cyan);
        jLabelSetTime.setText("Horas");
        jLabelSetTime.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabelSetTime.setMinimumSize(new java.awt.Dimension(33, 22));
        jLabelSetTime.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabelSetDate.setBackground(java.awt.Color.cyan);
        jLabelSetDate.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelSetDate.setForeground(java.awt.Color.cyan);
        jLabelSetDate.setText("Data");
        jLabelSetDate.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabelSetDate.setPreferredSize(new java.awt.Dimension(100, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelHoras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabelData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelByrinhasClock))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelByrinhasClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoras)
                    .addComponent(jLabelData)
                    .addComponent(jLabelSetTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setForeground(java.awt.Color.gray);
        jPanel2.setPreferredSize(new java.awt.Dimension(380, 80));

        jLabelByrinhasAlarm.setBackground(java.awt.Color.darkGray);
        jLabelByrinhasAlarm.setFont(new java.awt.Font("Serif", 1, 19)); // NOI18N
        jLabelByrinhasAlarm.setForeground(java.awt.Color.darkGray);
        jLabelByrinhasAlarm.setText("Byrinha's alarm");

        jLabelSetAlarm.setBackground(java.awt.Color.darkGray);
        jLabelSetAlarm.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelSetAlarm.setForeground(java.awt.Color.darkGray);
        jLabelSetAlarm.setText("Set alarm >>");

        jTextFieldHour.setBackground(java.awt.Color.lightGray);
        jTextFieldHour.setForeground(java.awt.Color.darkGray);
        jTextFieldHour.setMaximumSize(new java.awt.Dimension(33, 18));
        jTextFieldHour.setMinimumSize(new java.awt.Dimension(33, 18));
        jTextFieldHour.setPreferredSize(new java.awt.Dimension(33, 18));
        jTextFieldHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHourActionPerformed(evt);
            }
        });

        jTextFieldMinutes.setBackground(java.awt.Color.lightGray);
        jTextFieldMinutes.setForeground(java.awt.Color.darkGray);
        jTextFieldMinutes.setMaximumSize(new java.awt.Dimension(33, 18));
        jTextFieldMinutes.setMinimumSize(new java.awt.Dimension(33, 18));
        jTextFieldMinutes.setPreferredSize(new java.awt.Dimension(33, 18));

        jLabelHorasDoubleDote1.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelHorasDoubleDote1.setForeground(java.awt.Color.darkGray);
        jLabelHorasDoubleDote1.setText("::");

        jLabelHorasDoubleDote2.setBackground(java.awt.Color.darkGray);
        jLabelHorasDoubleDote2.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelHorasDoubleDote2.setForeground(java.awt.Color.darkGray);
        jLabelHorasDoubleDote2.setText("::");

        jButtonCancelSet.setBackground(java.awt.Color.darkGray);
        jButtonCancelSet.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
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
        jLabelAlarmStatus.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabelAlarmStatus.setForeground(java.awt.Color.darkGray);
        jLabelAlarmStatus.setText("Alarm status:");

        jButtonSetAlarm.setBackground(java.awt.Color.darkGray);
        jButtonSetAlarm.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
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

        jLabelSetStatus.setBackground(java.awt.Color.green);
        jLabelSetStatus.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelSetStatus.setForeground(java.awt.Color.red);
        jLabelSetStatus.setText("{ . . . }");
        jLabelSetStatus.setMaximumSize(new java.awt.Dimension(126, 16));
        jLabelSetStatus.setMinimumSize(new java.awt.Dimension(35, 16));
        jLabelSetStatus.setPreferredSize(new java.awt.Dimension(126, 16));
        jLabelSetStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSetStatusMouseClicked(evt);
            }
        });

        jLabelAlarm.setBackground(java.awt.Color.green);
        jLabelAlarm.setFont(new java.awt.Font("Serif", 1, 13)); // NOI18N
        jLabelAlarm.setForeground(java.awt.Color.blue);
        jLabelAlarm.setText("{ . . . }");
        jLabelAlarm.setMaximumSize(new java.awt.Dimension(126, 16));
        jLabelAlarm.setMinimumSize(new java.awt.Dimension(35, 16));
        jLabelAlarm.setPreferredSize(new java.awt.Dimension(126, 16));
        jLabelAlarm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAlarmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelSetAlarm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHorasDoubleDote1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelByrinhasAlarm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabelAlarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHorasDoubleDote2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButtonSetAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelAlarmStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSetStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSetAlarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCancelSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelByrinhasAlarm)
                            .addComponent(jLabelAlarmStatus)
                            .addComponent(jLabelSetStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAlarm, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSetAlarm)
                            .addComponent(jTextFieldHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHorasDoubleDote1)
                            .addComponent(jLabelHorasDoubleDote2))))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHourActionPerformed

    }//GEN-LAST:event_jTextFieldHourActionPerformed

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

    private void jLabelSetStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSetStatusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelSetStatusMouseClicked

    private void jButtonSetAlarmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSetAlarmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSetAlarmMouseClicked

    private void jLabelAlarmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAlarmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelAlarmMouseClicked

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
    private javax.swing.JLabel jLabelAlarm;
    private javax.swing.JLabel jLabelAlarmStatus;
    private javax.swing.JLabel jLabelByrinhasAlarm;
    private javax.swing.JLabel jLabelByrinhasClock;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHoras;
    private javax.swing.JLabel jLabelHorasDoubleDote1;
    private javax.swing.JLabel jLabelHorasDoubleDote2;
    private javax.swing.JLabel jLabelSetAlarm;
    private javax.swing.JLabel jLabelSetDate;
    private javax.swing.JLabel jLabelSetStatus;
    private javax.swing.JLabel jLabelSetTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldHour;
    private javax.swing.JTextField jTextFieldMinutes;
    // End of variables declaration//GEN-END:variables
}
