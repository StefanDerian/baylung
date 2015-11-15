/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Benny
 */
public class Rule {
    boolean evaluated = false;
    ArrayList <antecedent> antecedents;
    double CF;
    String consequence_id;
    double CFuser = 0;
    public Rule(double CF ,ArrayList <antecedent> antecedents, String consequence_id ){
        this.CF = CF;
        this.antecedents = antecedents;
        this.consequence_id = consequence_id;
    }
    public double get_CF(){
        return this.CF;
    }
    public ArrayList<antecedent> get_antecedents(){
        return this.antecedents;
    }
    public String get_consequence(){
        return this.consequence_id;
    }
    public HashMap<String,user_facts> calculateUser(HashMap<String,user_facts>WM){
        Double CFCombined = 0.0;
        for(int i = 0 ; i<antecedents.size();i++){
            
            if(i == 0){
                 if(WM.containsKey(antecedents.get(i).id)){
                    CFCombined = WM.get(antecedents.get(i).id).CF;
                }else{
                    CFCombined = 0.0 ;
                }
            }else{
                double CFCalc;
                if(WM.containsKey(antecedents.get(i).id)){
                    CFCalc = WM.get(antecedents.get(i).id).CF;
                }else{
                    CFCalc = 0.0 ;
                }
                if(antecedents.get(i).not == 1){
                    CFCalc = 1- CFCalc;
                }
                if (antecedents.get(i).connector == 0){
                    CFCombined = Math.min(CFCalc, CFCombined);
                }else{
                    CFCombined = Math.max(CFCalc, CFCombined);
                }   
            }
            
        }
        this.CFuser = CFCombined*CF;
        if(this.CFuser != 0){
                
            if(WM.containsKey(consequence_id)){
                WM.get(consequence_id).add_same_fact(consequence_id, this.CFuser);
                    
            }else{
                user_facts UF = new user_facts();
                UF.add_same_fact(consequence_id, this.CFuser);
                WM.put(consequence_id,UF);
                } 
            WM.get(consequence_id).calculate_CF();
            evaluated = true;
        }
        return WM;
    }
    
    public Double get_CF_user(){
        return this.CFuser;
    }
    
    public void print_antecedent(){
        for (int i = 0 ; i<antecedents.size();i++){
            System.out.print(antecedents.get(i).not+" "+antecedents.get(i).id+" "+antecedents.get(i).connector+" ");
        }
    }
}
