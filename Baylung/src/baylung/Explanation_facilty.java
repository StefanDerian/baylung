/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benny
 */
public class Explanation_facilty {
    public HashMap<String,String> diseases = new HashMap<String,String>();
    public HashMap<String,String> diagnosstic = new HashMap<String,String>();
    private static Connection koneksi;
    public void get_diseases() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
        
            if(koneksi == null){
                System.out.print("not konek");
            }
            else{
             System.out.print("konek");
            }
            Statement state = koneksi.createStatement();
            Statement state2 = koneksi.createStatement();
            ResultSet diseaseResult = state.executeQuery("SELECT * FROM linguistic_variable WHERE type = 'disease'");
            ResultSet diagnosticResult = state2.executeQuery("SELECT * FROM linguistic_variable WHERE type = 'diagnostic'");
            while(diseaseResult.next()){
                diseases.put(diseaseResult.getString("id_linguistic"),diseaseResult.getString("linguistic_name") ); 
            }
            while(diagnosticResult.next()){
                diagnosstic.put(diagnosticResult.getString("id_linguistic"),diagnosticResult.getString("linguistic_name") ); 
            }
    }
    
    public ArrayList<String> getDiseaseIdList(HashMap<String,user_facts> WM){
        ArrayList<String> disease_ids = new ArrayList<String>();
        for(String diseasekey: diseases.keySet()){
           
           if(WM.containsKey(diseasekey)){
               if(WM.get(diseasekey).CF > 0){
                    disease_ids.add(diseasekey);
               }
           }   
        }
        return disease_ids;
    }
    
    
    public String print_disease(HashMap<String,user_facts> WM){
        String resulter ="";
        resulter+="Since you have ";
        for(String diseasekey: diseases.keySet()){
           
           if(WM.containsKey(diseasekey)){
               resulter += diseases.get(diseasekey)+" ("+WM.get(diseasekey).CF +")"+", ";
               System.out.println(resulter);
           }
               
            
        }
        resulter += "/n you have at mosts: ";
        
        
        return resulter;
    }
    
    
    
    
    
}
