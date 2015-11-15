/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Benny
 */
public class Baylung {
    private static Connection koneksi;
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
        
            if(koneksi == null){
                System.out.print("not konek");
            }
            else{
             System.out.print("konek");
            }
            Statement state = koneksi.createStatement();
            ResultSet ruleResult = state.executeQuery("SELECT * FROM rules");
            while(ruleResult.next()){
                ArrayList<antecedent> antecedents = new ArrayList<antecedent>();
                String rule_id = ruleResult.getString("id_rule");
                double CF = Double.valueOf(ruleResult.getString("CF"));
                String consequent_id = ruleResult.getString("id_linguistic");
                Statement antecedent_state = koneksi.createStatement();
                ResultSet antecedentResult = antecedent_state.executeQuery("SELECT id_linguistic,`not`,connector  FROM rule_relation where id_rule = "+rule_id+" ORDER BY connector ASC");
                while (antecedentResult.next()){
                    antecedent antc = new antecedent(antecedentResult.getString("id_linguistic"),antecedentResult.getInt("not"),antecedentResult.getInt("connector"));
                    antecedents.add(antc);
                }
                Rule rule = new Rule (CF,antecedents,consequent_id);
                rule.print_antecedent();
                System.out.println();
                System.out.println();
                
                
            }
            
    } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
        e.printStackTrace();
        } 
        
    }
    
}
