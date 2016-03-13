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
import ga.*;
/**
 *
 * @author Benny
 */
public class detailation extends javax.swing.JPanel {

    /**
     * Creates new form detailation
     */
    ArrayList<generic_medicine> GM = new ArrayList<generic_medicine>();  
    
   
   ArrayList<medicine> mlist = new ArrayList<medicine>();
   ArrayList<HashMap<String,String>> diseaseData = new ArrayList<HashMap<String,String>>(); 
   ArrayList<HashMap<String,String>> drugData = new ArrayList<HashMap<String,String>>();
   
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
        
        fetch_title(diseaseid,WM);
        title.setText(diseaseText);
        
        par.setText(explainationtext);
       
        
        
        fetch_reason(diseaseid,WM);
        fetch_drugs(diseaseid,WM);
        
    }
    public void fetch_title(String id,HashMap<String, user_facts> WM) throws SQLException, ClassNotFoundException{
        Statement state = koneksi.createStatement();
        ResultSet diseaseResult = state.executeQuery("SELECT * FROM linguistic_variable WHERE type = 'disease' AND id_linguistic = "+id);
        if(diseaseResult.next()){
            this.diseaseText = diseaseResult.getString("linguistic_name")+"("+WM.get(id).get_CF()+")";
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
                + "(SELECT linguistic_name as consequent,linguistic_variable.id_linguistic as consequent_id,rules.id_rule as rule_id FROM linguistic_variable "
                + "INNER JOIN rules ON rules.id_linguistic = linguistic_variable.id_linguistic) consequent "
                + "INNER JOIN (SELECT explaination,rule_relation.id_rule as rule_id,linguistic_variable.id_linguistic as antecedent_id,linguistic_variable.linguistic_name as antecedent FROM linguistic_variable INNER JOIN rule_relation on rule_relation.id_linguistic "
                + "= linguistic_variable.id_linguistic) antecedent_j ON consequent.rule_id = antecedent_j.rule_id WHERE consequent_id = "+id);
        
        
        
        while(reason_result.next()){
            if(WM.containsKey(reason_result.getString("antecedent_id"))){
                if(WM.get(reason_result.getString("antecedent_id")).get_CF()>0){
                    HashMap<String,String> diseaseDatum = new HashMap<String,String>();
                    diseaseDatum.put("linguistic_name", reason_result.getString("antecedent"));
                    diseaseDatum.put("CF",String.valueOf(WM.get(reason_result.getString("antecedent_id")).get_CF()));
                    diseaseDatum.put("explaination", reason_result.getString("explaination"));
                    diseaseData.add(diseaseDatum);
                    
                } 
            }
        }
        
        causesPane.setText(buildCausesHTML(this.diseaseData));
        
        
    }
    public String buildCausesHTML(ArrayList<HashMap<String,String>> diseaseData){
        String tag = "<html>";
        tag += "<body>";
        tag += "<H1>Since You Have:</H1>";
        tag+="<table border = '2px'>";
        tag+="<tr>"
                +"<td>"
                +"<b>Causes</b>"
                + "</td>"
                +"<td>"
                +"<b>CF</b>"
                + "</td>"
                +"<td>"
                +"<b>Explaination</b>"
                + "</td>"
                + "</tr>";
        for(int i = 0; i < diseaseData.size();i++){
            tag+="<tr>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("linguistic_name");
            tag+="</td>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("CF");
            tag+="</td>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("explaination");
            tag+="</td>";
            tag+="</tr>";
        }
        tag+="</table>";
        tag += "</body>";
        tag+="</html>";
        return tag;
    }
    public String buildGenDrugsHTML(ArrayList<HashMap<String,String>> diseaseData){
        String tag = "<html>";
        tag += "<H1>Generic Drug Needed:</H1>";
        tag+="<table border = '2px'>";
        tag+="<tr>"
                +"<td>"
                +"<b>Name</b>"
                + "</td>"
                +"<td>"
                +"<b>Price</b>"
                + "</td>"
                +"<td>"
                +"<b>Explaination</b>"
                + "</td>"
                + "</tr>";
        for(int i = 0; i < diseaseData.size();i++){
            tag+="<tr>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("name");
            tag+="</td>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("price");
            tag+="</td>";
            tag+="<td>";
            tag+=diseaseData.get(i).get("explaination");
            tag+="</td>";
            tag+="</tr>";
        }
        tag+="</table>";
        tag+="</html>";
        return tag;
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
                 this.drugData.add(drugsneededDetail);
                 this.GM.add(new generic_medicine(drug_result.getString("drugs_id"),drug_result.getString("name"),drug_result.getDouble("price")));
                 if(WM.containsKey(drug_result.getString("id_condition"))){
                     if(drug_result.getInt("not_in") == 0){
                         drugsneeded.put(drug_result.getString("drugs_id"), drugsneededDetail);
                         
                         
                         medicine m = new medicine(drug_result.getString("name"),drug_result.getDouble("price"),drug_result.getDouble("miligram"));
                         this.mlist.add(m);
                     }
                 }else{
                     drugsneeded.put(drug_result.getString("drugs_id"), drugsneededDetail);
                     
                 }
                 
                 genDrugPanel.setText(buildGenDrugsHTML(this.drugData));
                 
                 
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

        scrollbar1 = new java.awt.Scrollbar();
        title = new javax.swing.JLabel();
        budget = new java.awt.Button();
        budgetText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        limit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jScrollPane3 = new javax.swing.JScrollPane();
        par = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        causesPane = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        genDrugPanel = new javax.swing.JTextPane();
        patentPanel = new javax.swing.JPanel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        title.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        title.setText("The Disease");

        budget.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        budget.setLabel("Purchase Tips");
        budget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                budgetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Budget");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Trial");

        par.setEditable(false);
        par.setContentType("text/html"); // NOI18N
        par.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane3.setViewportView(par);

        causesPane.setEditable(false);
        causesPane.setContentType("text/html"); // NOI18N
        jScrollPane6.setViewportView(causesPane);

        jScrollPane4.setViewportView(jScrollPane6);

        genDrugPanel.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(genDrugPanel);

        patentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        patentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 333, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(657, 657, 657)
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(budgetText, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1364, 1364, 1364))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(budgetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(budget, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void budgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_budgetActionPerformed
        // TODO add your handling code here:
        if(budgetText.getText() == " "){
            
        }else{
            
            try {
                drugsPurchase DP = new drugsPurchase(this.GM,Double.parseDouble(budgetText.getText()),Integer.parseInt(limit.getText()));
                patentPanel.removeAll();
                patentPanel.add(DP);
                patentPanel.revalidate();
                patentPanel.repaint();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(detailation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(detailation.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            
        }
    }//GEN-LAST:event_budgetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button budget;
    private javax.swing.JTextField budgetText;
    private java.awt.Canvas canvas1;
    private javax.swing.JTextPane causesPane;
    private javax.swing.JTextPane genDrugPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField limit;
    private javax.swing.JTextPane par;
    private javax.swing.JPanel patentPanel;
    private java.awt.Scrollbar scrollbar1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
