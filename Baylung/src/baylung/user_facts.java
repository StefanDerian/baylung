/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;

import java.util.ArrayList;

/**
 *
 * @author Benny
 */
public class user_facts {
    public ArrayList<antecedent_user> AU = new ArrayList<antecedent_user>();
    Double CF;
    private int scan_index = 0;
    public void add_same_fact(String id , double CF ,String ruleId, boolean sure){
        
        
        if(AU.isEmpty()){
            this.AU.add(new antecedent_user(id,CF,ruleId,sure));
        }else{
            if(scan_antecedents(ruleId)){
                calculate_CF();
                AU.get(scan_index).id = id;
                AU.get(scan_index).CF = CF;
                AU.get(scan_index).from_rule = ruleId;
                AU.get(scan_index).sure = sure;
            }else{
                this.AU.add(new antecedent_user(id,CF,ruleId,sure));
            }
        }
        
        
        calculate_CF();
    }
    public boolean scan_sureness(){
        for(int i = 0; i < AU.size() ; i ++){
            if(!AU.get(i).sure){
                
                return false;
            }
        }
        return true;
    }
    
    public boolean scan_antecedents(String id){
        for(int i = 0; i < AU.size() ; i ++){
            if(AU.get(i).from_rule.equals(id)){
                scan_index = i;
                return true;
}
        }
        return false;
    }
    public void calculate_CF(){
        if(AU.size()==1){
            this.CF = AU.get(0).CF;
        }else if(AU.isEmpty()){
            this.CF = 0.0;
        }else{
            
            double newCF = 0 ;
            for(int i = 1 ;i<AU.size();i++){
                double CF2 = AU.get(i).CF;
                double CF1 = AU.get(i-1).CF;
                
                if(CF1 >0 && CF2>0 ){
                    newCF = CF1+CF2-(CF1*CF2);
                }else if(CF1<0 && CF2 <0){
                    newCF = CF1+CF2+(CF1*CF2);
                }else{
                    newCF = (CF1+CF2)/(1-Math.min(Math.abs(CF1), Math.abs(CF2)));
                }
            }
            this.CF = newCF;
        }
    }
    
    public void print_antecedents(){
        for(int i = 0; i<this.AU.size();i++){
            System.out.print(this.AU.get(i).id +" CF:"+this.AU.get(i).CF+" ");
        }
        System.out.print(" CF total:"+get_CF());
        System.out.println();
    }
    
    
    
    public double get_CF(){
        return this.CF;
    }
    
    
    
    
}
