/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end;

import baylung.ruleProcess;
import baylung.user_facts;
import baylung.Explanation_facilty;

import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import panel.detailation;

/**
 *
 * @author Benny
 */
public class Result extends javax.swing.JFrame {
    private static Connection koneksi;
    HashMap<String,user_facts> WM = new HashMap<String,user_facts>();
    Explanation_facilty EP = new Explanation_facilty();
    ArrayList<detailation> disease_detail = new ArrayList<detailation>();
    ArrayList<JScrollPane>cardScrollPanes = new ArrayList<JScrollPane>();
    int cardsize = 0;
    int current = 0;
    CardLayout cl;
     /**
     * Creates new form Result
     */
    public Result() throws ClassNotFoundException, SQLException {
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

        list1 = new java.awt.List();
        diseaseCard = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        diseaseListCon = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        diseaseCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        diseaseCard.setAutoscrolls(true);
        diseaseCard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        diseaseCard.setLayout(new java.awt.CardLayout());

        label1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        label1.setText("Other Possible Diseases");

        diseaseListCon.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        diseaseListCon.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        diseaseListCon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        diseaseListCon.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                diseaseListConValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(diseaseListCon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(diseaseCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(762, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(diseaseCard, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ruleProcess rp = new ruleProcess();
        
        rp.set_hashmap(WM);
        rp.print_WM();
         try {
             rp.set_rules();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
        rp.infer();
        System.out.println();
        rp.print_WM();
        String result = rp.get_max_CF();
         try {
             Class.forName("com.mysql.jdbc.Driver");
            try {
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
            } catch (SQLException ex) {
                Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
        Statement state = null;
         try {
             state = koneksi.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
             ResultSet ruleResult = state.executeQuery("SELECT * FROM linguistic_variable WHERE id_linguistic ="+result+" LIMIT 1");
             String label = "";
             if (ruleResult.next()){
                label = ruleResult.getString("linguistic_name");
            }
             
         } catch (SQLException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         try {
             EP.get_diseases();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         try {
             addCard();
         } catch (SQLException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_formWindowOpened

    private void addCard() throws SQLException, ClassNotFoundException{
        
        ArrayList<String> diseaseids = EP.getDiseaseIdList(WM);
        ArrayList<String> diseaseList = EP.diseaseListed;
        DefaultListModel<String> diseaseListModel = new DefaultListModel<>();
        for(int i = 0 ; i <diseaseids.size();i++){
            JScrollPane cardScroll = new JScrollPane(new detailation(diseaseids.get(i),WM));
            cardScrollPanes.add(cardScroll);
            
            diseaseCard.add(cardScroll);
            diseaseListModel.addElement(diseaseList.get(i));
        }
        diseaseListCon.setModel(diseaseListModel);
        cl = (CardLayout) (diseaseCard.getLayout());
        
    }
    
    private void diseaseListConValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_diseaseListConValueChanged
        // TODO add your handling code here:
        int selectedIndex = diseaseListCon.getSelectedIndex();
        diseaseCard.removeAll();
        diseaseCard.add(cardScrollPanes.get(selectedIndex));
        diseaseCard.revalidate();
        diseaseCard.repaint();
    }//GEN-LAST:event_diseaseListConValueChanged

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
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Result.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Result().setVisible(true);
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Result.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel diseaseCard;
    private javax.swing.JList diseaseListCon;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
