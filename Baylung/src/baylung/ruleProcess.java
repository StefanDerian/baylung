/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.sql.*;
import java.util.Iterator;
/**
 *
 * @author Benny
 */
public class ruleProcess {
    HashMap<String,user_facts> WM = new HashMap<String,user_facts>();
    LinkedHashMap<String,ArrayList<Rule>> rules = new LinkedHashMap<String,ArrayList<Rule>>();
    String rule_table = "rules";
    String antecedents_table = "rule_relation";
    private static Connection koneksi;
    
    public void set_rules() throws ClassNotFoundException, SQLException{
        
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
        
            if(koneksi == null){
                System.out.print("not konek");
            }
            else{
             System.out.print("konek");
            }
            Statement state = koneksi.createStatement();
            ResultSet ruleResult = state.executeQuery("SELECT * FROM "+rule_table);
            while(ruleResult.next()){
                String rule_id = ruleResult.getString("id_rule");
                String consequence_id = ruleResult.getString("id_linguistic");
                Double CF = ruleResult.getDouble("CF");
                Statement sub_state = koneksi.createStatement();
                ResultSet antecedents = sub_state.executeQuery("SELECT * FROM "+antecedents_table+" WHERE id_rule ="+rule_id+" ORDER BY connector ASC");
                ArrayList <antecedent>antecedent_list = new ArrayList<antecedent>();
                
                while(antecedents.next()){
                    String antecedents_id = antecedents.getString("id_linguistic");
                    int connector = antecedents.getInt("connector");
                    int not = antecedents.getInt("not");
                    antecedent aantecedent = new antecedent(antecedents_id,not,connector);
                    antecedent_list.add(aantecedent);
                }
                Rule arule = new Rule(CF,antecedent_list,consequence_id); 
                if(rules.containsKey(consequence_id)){
                    rules.get(consequence_id).add(arule);
                }else{
                    rules.put(consequence_id, new ArrayList<Rule>());
                    rules.get(consequence_id).add(arule);
                }   
            }
    }
    public void print_rules(){
      for(String ruleKey:rules.keySet()){
            for(int j = 0 ;j<rules.get(ruleKey).size();j++){
                rules.get(ruleKey).get(j).print_antecedent(); 
                System.out.println();
            }
             System.out.println();
        }
    }
    
    public String get_max_CF(){
        Iterator WMI = WM.keySet().iterator();
        String result="";
        double CF_begin = -1;
        for(String WMkey:WM.keySet()){
            if(WM.get(WMkey).CF >= CF_begin && rules.containsKey(WMkey)){
                CF_begin = WM.get(WMkey).CF;
                result = WMkey;
            }
           
        }
        
        return result;
        
    }
    public void print_WM(){
        for(String WMkey:WM.keySet()){
            WM.get(WMkey).print_antecedents();
            System.out.println();
           
        }
    }
    
    
    
    public void infer(){
        boolean repeat = false;
       
        for(String ruleKey:rules.keySet()){
            System.out.println("repeat");
            ArrayList<Rule> singleRule = rules.get(ruleKey);
            for(int i = 0 ;i<singleRule.size();i++){
                if(!singleRule.get(i).evaluated){
                    WM = singleRule.get(i).calculateUser(WM);
                    if(singleRule.get(i).evaluated){
                        
                        infer();
                        repeat = true;
                        break;
                    }
                }
            }
            if(repeat){
                break;
            }  
        }
        
        
        
        
    }
    
    public void set_hashmap(HashMap<String,user_facts> WM){
        this.WM = WM;
    }
    
    
    
    
    
    
    
    
    
    
    
}
