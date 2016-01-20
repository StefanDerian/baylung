/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front_end;
import baylung.*;
import java.util.HashMap;
/**
 *
 * @author Benny
 */
public class insertion {
    
    
    public double CFcalculate(double MB, double MD){
        return MB-MD;
    }
    public double text_input(String input){
        if(input== " "){
             return 0;
        }else{
            return Double.parseDouble(input);
        }
    }
    public HashMap<String,user_facts> insert(HashMap<String,user_facts> WM,String id, double CF,boolean sure){
        
        if(WM.containsKey(id)){
            WM.get(id).add_same_fact(id, CF,"",sure);
        }else{
            user_facts UF = new user_facts();
            UF.add_same_fact(id, CF,"",sure);
            WM.put(id, UF);
        }
        return WM;
        
    }
    
    
    
    
}
