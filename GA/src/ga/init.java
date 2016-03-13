/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benny
 */
public class init {
    ArrayList<generic_medicine> GM;
    ArrayList<ArrayList<patent_medicine>>patent_medicine;
    ArrayList<chrom> population;
    private static Connection koneksi;
    
    public init(ArrayList<generic_medicine> GM) throws ClassNotFoundException, SQLException{
        this.GM = GM;
        patent_medicine = new ArrayList<ArrayList<patent_medicine>>();
        population = new ArrayList<chrom>();
        get_patent();
        get_chromosomes();
    }
    public void get_patent() throws ClassNotFoundException, SQLException{
       
        Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/baylung","root","");
        
            if(koneksi == null){
                System.out.print("not konek");
            }
            else{
             System.out.print("konek");
            }
            
            
        for(int i = 0 ; i <GM.size() ; i++){
            ArrayList<patent_medicine>single_PM = new ArrayList<patent_medicine>();
            Statement state = koneksi.createStatement();
            ResultSet patentResult = state.executeQuery("SELECT * FROM drug_patent WHERE id_generic_drug = "+GM.get(i).generic_id);
            while(patentResult.next()){
                 patent_medicine PM = new patent_medicine(GM.get(i).generic_id,GM.get(i).generic_name,GM.get(i).generic_price
                 ,patentResult.getString("id_drug"),patentResult.getString("name"),patentResult.getDouble("price"),patentResult.getString("explaination"));
                single_PM.add(PM);
            }
            patent_medicine.add(single_PM);
        }
    }
    public void get_chromosomes(){
        
        Random r  = new Random();
        for(int j = 0 ; j < 6;j++){
            ArrayList<Integer> chromosome = new ArrayList<Integer>();
            for(int i = 0 ; i<patent_medicine.size();i++){
                int rand = r.nextInt(patent_medicine.get(i).size());
                chromosome.add(rand);
            }
            chrom c = new chrom(chromosome,patent_medicine);
            population.add(c);
        }
        
    }
    public void print_PM(){
        for(int i = 0 ; i < patent_medicine.size();i++){
            for(int j = 0 ;j<patent_medicine.get(i).size();j++){
                System.out.print(patent_medicine.get(i).get(j).patent_id+" "+patent_medicine.get(i).get(j).patent_price+" ");
            }
            
            System.out.println();
        }
    }
    public void print_chromosomes(){
        for(int i = 0 ; i < population.size();i++){
            for(int j = 0 ;j<population.get(i).index.size();j++){
                System.out.print(population.get(i).index.get(j)+" ");
                
            }
            
            System.out.println();
        }
    }
     public void print_population(ArrayList<chrom> p){
        for(int i = 0 ; i < p.size();i++){
            for(int j = 0 ;j<p.get(i).index.size();j++){
                System.out.print(p.get(i).index.get(j)+" ");
                
            }
            
            System.out.println();
        }
    }
    
}
