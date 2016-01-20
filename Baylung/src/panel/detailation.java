/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

import baylung.user_facts;
import genetic_algorithm.medicine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Benny
 */
public class detailation extends javax.swing.JPanel {

    /**
     * Creates new form detailation
     */
    Object[] columns = {"causes","detail","CF"};
    DefaultTableModel model = new DefaultTableModel();
   ArrayList<medicine> mlist = new ArrayList<medicine>();
    DefaultTableModel drugsModel = new DefaultTableModel();
    Object[] drugsColums = {"name","explaination","miligram"};
    HashMap<String , HashMap<String,String>> drugsneeded = new HashMap<String,HashMap<String,String>>();
    String diseaseText;
    String explainationtext;
    String diseaseid;
    private static Connection koneksi;
    public detailation(String diseaseid,HashMap<String, user_facts> WM) throws SQLException, ClassNotFoundException {
        initComponents();
        Class.forName("com.mysql.jdbc.Driver");
        koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
        
        fetch_title(diseaseid);
        title.setText(diseaseText);
        explaination.setText(explainationtext);
        model.setColumnIdentifiers(columns);
        causes.setModel(model);
        drugsModel.setColumnIdentifiers(drugsColums);
        medicine.setModel(drugsModel);
        fetch_reason(diseaseid,WM);
        fetch_drugs(diseaseid,WM);
    }
    public void fetch_title(String id) throws SQLException, ClassNotFoundException{
        Statement state = koneksi.createStatement();
        ResultSet diseaseResult = state.executeQuery("SELECT * FROM linguistic_variable WHERE type = 'disease' AND id_linguistic = "+id);
        if(diseaseResult.next()){
            this.diseaseText = diseaseResult.getString("linguistic_name");
            this.explainationtext = diseaseResult.getString("explaination");
        }
    }
    public void fetch_reason(String id , HashMap<String, user_facts> WM) throws SQLException{
        Statement reason_state = koneksi.createStatement();
        Statement count_state = koneksi.createStatement();
        ResultSet count_result = count_state.executeQuery("SELECT COUNT(*) as numb FROM "
                + "(SELECT linguistic_name as consequent,linguistic_variable.id_linguistic as consequent_id,rules.id_rule as rule_id,explaination FROM linguistic_variable "
                + "INNER JOIN rules ON rules.id_linguistic = linguistic_variable.id_linguistic) consequent "
                + "INNER JOIN (SELECT rule_relation.id_rule as rule_id,linguistic_variable.id_linguistic as antecedent_id,linguistic_variable.linguistic_name as antecedent FROM linguistic_variable INNER JOIN rule_relation on rule_relation.id_linguistic "
                + "= linguistic_variable.id_linguistic) antecedent_j ON consequent.rule_id = antecedent_j.rule_id WHERE consequent_id = "+id);
        
        if(count_result.next()){
            if(count_result.getInt("numb") == 0){
                return;
            }
        }
        ResultSet reason_result = reason_state.executeQuery("SELECT * FROM "
                + "(SELECT linguistic_name as consequent,linguistic_variable.id_linguistic as consequent_id,rules.id_rule as rule_id,explaination FROM linguistic_variable "
                + "INNER JOIN rules ON rules.id_linguistic = linguistic_variable.id_linguistic) consequent "
                + "INNER JOIN (SELECT rule_relation.id_rule as rule_id,linguistic_variable.id_linguistic as antecedent_id,linguistic_variable.linguistic_name as antecedent FROM linguistic_variable INNER JOIN rule_relation on rule_relation.id_linguistic "
                + "= linguistic_variable.id_linguistic) antecedent_j ON consequent.rule_id = antecedent_j.rule_id WHERE consequent_id = "+id);
        
        
        
        while(reason_result.next()){
            if(WM.containsKey(reason_result.getString("antecedent_id"))){
                if(WM.get(reason_result.getString("antecedent_id")).get_CF()>0){
                    model.addRow(new Object[]{reason_result.getString("antecedent"),reason_result.getString("explaination")
                    ,WM.get(reason_result.getString("antecedent_id")).get_CF()});
                } 
            }
        }
        
        
        
        
    }
    public void fetch_drugs(String id, HashMap<String,user_facts> WM) throws SQLException{
        Statement drug_state = koneksi.createStatement();
        
        try {
            ResultSet drug_result = drug_state.executeQuery("SELECT not_in,id_condition, drugs.id_drug as drugs_id "
                    + ",drugs.drugname as name, drugs.price as price, "
                    + "drugs.miligram as miligram, drugs.drug_explaination as explaination " +
                    "FROM drug_relation INNER JOIN drugs " +
                    "ON drugs.id_drug = drug_relation.id_drug where drug_relation.id_linguistic = "+id);
             while(drug_result.next()){
                 HashMap<String,String>drugsneededDetail = new HashMap<String,String>();
                 drugsneededDetail.put("name", drug_result.getString("name"));
                 drugsneededDetail.put("price", drug_result.getString("price"));
                 drugsneededDetail.put("miligram", drug_result.getString("miligram"));
                 drugsneededDetail.put("explaination", drug_result.getString("explaination"));
                 
                 if(WM.containsKey(drug_result.getString("id_condition"))){
                     if(drug_result.getInt("not_in") == 0){
                         drugsneeded.put(drug_result.getString("drugs_id"), drugsneededDetail);
                         drugsModel.addRow(new Object[]{drug_result.getString("name"), drug_result.getString("explaination"),
                         drug_result.getString("miligram")});
                         
                         medicine m = new medicine(drug_result.getString("name"),drug_result.getDouble("price"),drug_result.getDouble("miligram"));
                         this.mlist.add(m);
                     }
                 }else{
                     drugsneeded.put(drug_result.getString("drugs_id"), drugsneededDetail);
                     drugsModel.addRow(new Object[]{drug_result.getString("name"), drug_result.getString("explaination"),
                     drug_result.getString("miligram")});
                 }
                 
                 
                 
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(detailation.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        causes = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        explaination = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicine = new javax.swing.JTable();
        budget = new java.awt.Button();
        budgetText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setMinimumSize(new java.awt.Dimension(3200, 3600));

        causes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "causes", "detail", "CF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(causes);
        if (causes.getColumnModel().getColumnCount() > 0) {
            causes.getColumnModel().getColumn(0).setMinWidth(150);
            causes.getColumnModel().getColumn(0).setPreferredWidth(150);
            causes.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        title.setText("The Disease");

        explaination.setText("explaination");

        jScrollPane2.setMinimumSize(new java.awt.Dimension(3200, 3600));

        medicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "name", "explaination", "miligram"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(medicine);
        if (medicine.getColumnModel().getColumnCount() > 0) {
            medicine.getColumnModel().getColumn(0).setMinWidth(150);
            medicine.getColumnModel().getColumn(0).setPreferredWidth(150);
            medicine.getColumnModel().getColumn(0).setMaxWidth(150);
        }

        budget.setLabel("purchase tips");
        budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetActionPerformed(evt);
            }
        });

        jLabel1.setText("budget");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 920, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 920, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(explaination)
                            .addComponent(title)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(budgetText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(explaination)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(budgetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetActionPerformed
        // TODO add your handling code here:
        if(budgetText.getText() == " "){
            
        }else{
            Double budgetMoney = Double.parseDouble(budgetText.getText());
            
        }
    }//GEN-LAST:event_budgetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button budget;
    private javax.swing.JTextField budgetText;
    private javax.swing.JTable causes;
    private javax.swing.JLabel explaination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable medicine;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
