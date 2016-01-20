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
    boolean sure = true;
    String consequence_id;
    double CFuser = 0;
    String rule_id;
    public Rule(String rule_id,double CF ,ArrayList <antecedent> antecedents, String consequence_id ){
        this.CF = CF;
        this.rule_id = rule_id;
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
                    if(!WM.get(antecedents.get(i).id).scan_sureness()){
                        sure = false;
                    }
                    CFCombined = WM.get(antecedents.get(i).id).CF;
                }else{
                    sure = false;
                    CFCombined = 0.0 ;
                }
            }else{
                double CFCalc;
                if(WM.containsKey(antecedents.get(i).id)){
                     if(!WM.get(antecedents.get(i).id).scan_sureness()){
                        sure = false;
                     }
                    CFCalc = WM.get(antecedents.get(i).id).CF;
                }else{
                    sure = false;
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
            if(sure){
                evaluated = true;
            }   
            if(WM.containsKey(consequence_id)){
                WM.get(consequence_id).add_same_fact(consequence_id, this.CFuser,rule_id,sure);
                    
            }else{
                user_facts UF = new user_facts();
                UF.add_same_fact(consequence_id,this.CFuser,rule_id,sure);
                WM.put(consequence_id,UF);
                }
           
            
        }
        return WM;
    }
    
    public Double get_CF_user(){
        return this.CFuser;
    }
    
    public void print_antecedent(){
        for (int i = 0 ; i<antecedents.size();i++){
            String not;
            String connector;
            if(antecedents.get(i).not == 0){
                not = "";
            }else{
                not = "not";
            }
            if(antecedents.get(i).connector == 0){
                connector = "AND";
            }else{
                connector = "OR";
            }
            if(i == 0){
                 System.out.print(not+" "+antecedents.get(i).id+" ");
            }else{
               
                System.out.print(connector+" "+not+" "+antecedents.get(i).id+" ");
            }   
        }
        System.out.print("THEN: "+consequence_id  +" CF :"+CF);
    }
}
