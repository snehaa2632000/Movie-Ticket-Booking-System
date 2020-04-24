/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.ticket;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class H_confirm extends javax.swing.JFrame {

    String movie_name, time, sdate, email;
    Date date;
    int movie_id, timing_id, ticket_count, ticket_charges, theatre_id, cost, total;

    /**
     * Creates new form G_2Cinema
     */
    public H_confirm() {
        initComponents();
    }

    public H_confirm(String mname, int mid, Date d, String t, int tc, int tid, int time_id, String mail) {
        movie_name = mname;
        movie_id = mid;
        this.date = d;
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        sdate = df.format(d);
        time = t;
        ticket_count = tc;
        timing_id = time_id;
        email = mail;
        theatre_id = tid;

        Connection con = null;
        CallableStatement cs;
        String columnValue = "";

        try {
            //Class.forName("java.sql.DriverManager");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/package?characterEncoding=latin1", "root", "snehAA2632000");
            cs = con.prepareCall("{CALL getTheatre_pro(?)}");
            cs.setInt(1, theatre_id);
            ResultSet rs = cs.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        System.out.print(",");
                    }
                    columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }

            if (columnValue != "null") {
                String[] values = columnValue.split(";");
                cost = Integer.parseInt(values[3]);
                System.out.println(cost);
            }
            /*Statement stmt = (Statement) con.createStatement();
            String query = "Select cost from theatre where theatreid='" + theatre_id + "';";
            ResultSet rs = (ResultSet) stmt.executeQuery(query);
             */
            if (rs.next()) {
                cost = Integer.parseInt(rs.getString("cost"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ticket_charges = (cost * tc);
        total = ticket_charges + 100;

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

        jLabel_MovieName2 = new javax.swing.JLabel();
        jLabel_Total = new javax.swing.JLabel();
        jLabel_MovieName = new javax.swing.JLabel();
        jLabel_Booking = new javax.swing.JLabel();
        jLabel_Date = new javax.swing.JLabel();
        jLabel_logo = new javax.swing.JLabel();
        jButton_Confirm = new javax.swing.JButton();
        jLabel_BookingCharges = new javax.swing.JLabel();
        jLabel_time = new javax.swing.JLabel();
        jButton_Back = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_TicketCount = new javax.swing.JLabel();
        jLabel_time2 = new javax.swing.JLabel();
        jLabel_Date2 = new javax.swing.JLabel();
        jLabel_TicketCount2 = new javax.swing.JLabel();
        jLabel_BookingCharges2 = new javax.swing.JLabel();
        jLabel_TicketCharges2 = new javax.swing.JLabel();
        jLabel_Total2 = new javax.swing.JLabel();
        jLabel_TicketCharges = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(20, 20, 860, 800));
        setMinimumSize(new java.awt.Dimension(860, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(860, 800));
        getContentPane().setLayout(null);

        jLabel_MovieName2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_MovieName2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_MovieName2.setText(movie_name);
        getContentPane().add(jLabel_MovieName2);
        jLabel_MovieName2.setBounds(412, 280, 360, 30);

        jLabel_Total.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_Total.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Total.setText("Total");
        getContentPane().add(jLabel_Total);
        jLabel_Total.setBounds(250, 520, 50, 30);

        jLabel_MovieName.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_MovieName.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_MovieName.setText("Movie Name");
        getContentPane().add(jLabel_MovieName);
        jLabel_MovieName.setBounds(250, 280, 110, 30);

        jLabel_Booking.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel_Booking.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Booking.setText("Booking Details - Confirmation");
        getContentPane().add(jLabel_Booking);
        jLabel_Booking.setBounds(300, 220, 279, 28);

        jLabel_Date.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_Date.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Date.setText("Date ");
        getContentPane().add(jLabel_Date);
        jLabel_Date.setBounds(250, 320, 50, 30);

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo-edit.png"))); // NOI18N
        getContentPane().add(jLabel_logo);
        jLabel_logo.setBounds(80, 0, 200, 150);

        jButton_Confirm.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton_Confirm.setText("Confirm");
        jButton_Confirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton_Confirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Confirm);
        jButton_Confirm.setBounds(390, 590, 90, 34);

        jLabel_BookingCharges.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_BookingCharges.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_BookingCharges.setText("Booking Charges");
        getContentPane().add(jLabel_BookingCharges);
        jLabel_BookingCharges.setBounds(250, 440, 200, 30);

        jLabel_time.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_time.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_time.setText("Time");
        getContentPane().add(jLabel_time);
        jLabel_time.setBounds(250, 360, 50, 30);

        jButton_Back.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton_Back.setForeground(new java.awt.Color(240, 240, 240));
        jButton_Back.setText("Back");
        jButton_Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jButton_Back.setContentAreaFilled(false);
        jButton_Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Back);
        jButton_Back.setBounds(730, 660, 90, 34);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 150, 867, 10);

        jLabel_TicketCount.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_TicketCount.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_TicketCount.setText("Number of Tickets");
        getContentPane().add(jLabel_TicketCount);
        jLabel_TicketCount.setBounds(250, 400, 139, 30);

        jLabel_time2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_time2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_time2.setText(time);
        getContentPane().add(jLabel_time2);
        jLabel_time2.setBounds(412, 358, 110, 30);

        jLabel_Date2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_Date2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Date2.setText(sdate);
        getContentPane().add(jLabel_Date2);
        jLabel_Date2.setBounds(412, 319, 200, 30);

        jLabel_TicketCount2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_TicketCount2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_TicketCount2.setText(Integer.toString(ticket_count));
        getContentPane().add(jLabel_TicketCount2);
        jLabel_TicketCount2.setBounds(412, 400, 110, 30);

        jLabel_BookingCharges2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_BookingCharges2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_BookingCharges2.setText("Rs.100");
        getContentPane().add(jLabel_BookingCharges2);
        jLabel_BookingCharges2.setBounds(420, 440, 110, 30);

        jLabel_TicketCharges2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_TicketCharges2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_TicketCharges2.setText("Rs."+Integer.toString(ticket_charges));
        getContentPane().add(jLabel_TicketCharges2);
        jLabel_TicketCharges2.setBounds(410, 480, 110, 30);

        jLabel_Total2.setFont(new java.awt.Font("Traditional Arabic", 0, 17)); // NOI18N
        jLabel_Total2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Total2.setText("Rs."+Integer.toString(total));
        getContentPane().add(jLabel_Total2);
        jLabel_Total2.setBounds(410, 520, 110, 30);

        jLabel_TicketCharges.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        jLabel_TicketCharges.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_TicketCharges.setText("Ticket Charges");
        getContentPane().add(jLabel_TicketCharges);
        jLabel_TicketCharges.setBounds(250, 480, 150, 30);

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/spi-bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 870, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new F_shows(date, ticket_count, movie_id, movie_name, email).setVisible(true);
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jButton_ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConfirmActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new I_seat(ticket_count, timing_id, total, date, email).setVisible(true);
    }//GEN-LAST:event_jButton_ConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(H_confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(H_confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(H_confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(H_confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new H_confirm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Booking;
    private javax.swing.JLabel jLabel_BookingCharges;
    private javax.swing.JLabel jLabel_BookingCharges2;
    private javax.swing.JLabel jLabel_Date;
    private javax.swing.JLabel jLabel_Date2;
    private javax.swing.JLabel jLabel_MovieName;
    private javax.swing.JLabel jLabel_MovieName2;
    private javax.swing.JLabel jLabel_TicketCharges;
    private javax.swing.JLabel jLabel_TicketCharges2;
    private javax.swing.JLabel jLabel_TicketCount;
    private javax.swing.JLabel jLabel_TicketCount2;
    private javax.swing.JLabel jLabel_Total;
    private javax.swing.JLabel jLabel_Total2;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_time;
    private javax.swing.JLabel jLabel_time2;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}