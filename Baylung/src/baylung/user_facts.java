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

    public void add_same_fact(String id , double CF){
        this.AU.add(new antecedent_user(id,CF));
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
                    newCF = (CF1+CF2)/(1-Math.min(CF1, CF2));
                }
            }
            this.CF = newCF;
        }
    }
    
    public void print_antecedents(){
        for(int i = 0; i<this.AU.size();i++){
            System.out.print(this.AU.get(i).id +" "+this.AU.get(i).CF);
        }
        System.out.println();
    }
    
    
    
    public double get_CF(){
        return this.CF;
    }
    
    
    
    
}
