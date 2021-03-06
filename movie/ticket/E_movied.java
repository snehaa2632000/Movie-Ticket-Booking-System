/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.ticket;

import datechooser.beans.DateChooserCombo;
import java.awt.*;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class E_movied extends javax.swing.JFrame {

    int movie_id;
    String movie_name, image, description, rating, email;
    Image img;
    /**
     * Creates new form H_3fun
     */
    public E_movied() {
        initComponents();
        
    }

    public E_movied(int id, String mail) {
        movie_id = id;
        email = mail;
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

        jSeparator4 = new javax.swing.JSeparator();
        jLogout = new javax.swing.JButton();
        jHome = new javax.swing.JButton();
        jLabel_logo = new javax.swing.JLabel();
        Connection con=null;
        CallableStatement cs;
        String columnValue="";
        String pwd = "nill";
        try{

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/package?characterEncoding=latin1","root","snehAA2632000");
            cs = con.prepareCall("{CALL getMovieName_pro(?)}");
            cs.setInt(1, movie_id);
            ResultSet rs = cs.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1)
                    System.out.print(",  ");
                    columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
            if(columnValue != "null"){
                String[] values = columnValue.split(";");
                pwd = values[3];
                movie_name = values[0];
                image = values[2];
                description = values[1];
                rating = values[3];
                img = ImageIO.read(getClass().getResource("/pictures/" + image));

                System.out.println(pwd);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel_Rating = new javax.swing.JLabel();
        jLabel_rating2 = new javax.swing.JLabel();
        jLabel_numberTicket = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_description = new javax.swing.JTextArea();
        jLabel_date = new javax.swing.JLabel();
        jButton_book = new javax.swing.JButton();
        jLabel_movieName = new javax.swing.JLabel();
        jComboTicketCount = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(20, 20, 860, 800));
        setMinimumSize(new java.awt.Dimension(860, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(860, 800));
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(0, 167, 860, 10);

        jLogout.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLogout.setForeground(new java.awt.Color(240, 240, 240));
        jLogout.setText("Log Out");
        jLogout.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLogout.setBorderPainted(false);
        jLogout.setContentAreaFilled(false);
        jLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jLogout);
        jLogout.setBounds(790, 0, 65, 34);

        jHome.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jHome.setForeground(new java.awt.Color(240, 240, 240));
        jHome.setText("Home");
        jHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jHome.setBorderPainted(false);
        jHome.setContentAreaFilled(false);
        jHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });
        getContentPane().add(jHome);
        jHome.setBounds(730, 0, 58, 34);

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/logo-edit.png"))); // NOI18N
        getContentPane().add(jLabel_logo);
        jLabel_logo.setBounds(80, 0, 200, 170);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);

        jLabel15.setIcon(new ImageIcon(img));

        jLabel_Rating.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_Rating.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_Rating.setText("Rating :");

        jLabel_rating2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_rating2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_rating2.setText(rating+"/10");

        jLabel_numberTicket.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_numberTicket.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_numberTicket.setText("Number of Tickets :");

        jTextArea_description.setEditable(false);
        jTextArea_description.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea_description.setColumns(20);
        jTextArea_description.setFont(new java.awt.Font("Arial Unicode MS", 0, 13)); // NOI18N
        jTextArea_description.setLineWrap(true);
        jTextArea_description.setRows(5);
        jTextArea_description.setText(description);
        jTextArea_description.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea_description);

        jLabel_date.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_date.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_date.setText("Date :");

        jButton_book.setFont(new java.awt.Font("Tempus Sans ITC", 0, 15)); // NOI18N
        jButton_book.setText("Book");
        jButton_book.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_bookActionPerformed(evt);
            }
        });

        jLabel_movieName.setFont(new java.awt.Font("Shannon", 0, 19)); // NOI18N
        jLabel_movieName.setForeground(new java.awt.Color(240, 240, 240));
        jLabel_movieName.setText(movie_name);

        jComboTicketCount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboTicketCount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Date da = new Date();
        System.out.println(da);
        jDateChooser1.setMinSelectableDate(da);

        jBack.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jBack.setForeground(new java.awt.Color(240, 240, 240));
        jBack.setText("Back");
        jBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jBack.setContentAreaFilled(false);
        jBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel15)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_movieName)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_numberTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Rating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_rating2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton_book, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addComponent(jComboTicketCount, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(294, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_movieName)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_rating2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_Rating))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_numberTicket)
                            .addComponent(jComboTicketCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_date)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jButton_book, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(80, 190, 700, 500);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/spi-bg.jpg"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(0, -20, 880, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DNewhome(email).setVisible(true);
    }//GEN-LAST:event_jBackActionPerformed

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DNewhome(email).setVisible(true);
    }//GEN-LAST:event_jHomeActionPerformed

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new A_Home().setVisible(true);
    }//GEN-LAST:event_jLogoutActionPerformed

    private void jButton_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_bookActionPerformed
        // TODO add your handling code here:
        Date date = jDateChooser1.getDate();
        if (date == null) {
            JOptionPane.showMessageDialog(this, "Please Enter Date.");
        } else {
            int ticket_number = Integer.parseInt((String) jComboTicketCount.getSelectedItem());
            new F_shows(date, ticket_number, movie_id, movie_name, email).setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton_bookActionPerformed

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
            java.util.logging.Logger.getLogger(E_movied.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(E_movied.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(E_movied.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(E_movied.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new E_movied().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack;
    private javax.swing.JButton jButton_book;
    private javax.swing.JComboBox<String> jComboTicketCount;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JButton jHome;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel_Rating;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JLabel jLabel_movieName;
    private javax.swing.JLabel jLabel_numberTicket;
    private javax.swing.JLabel jLabel_rating2;
    private javax.swing.JButton jLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea_description;
    // End of variables declaration//GEN-END:variables
}
