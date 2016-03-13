/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.util.ArrayList;

/**
 *
 * @author Benny
 */
public class generation_updaate {
    public static ArrayList<chrom> steadyUpdate(ArrayList<chrom> parents,ArrayList<chrom> offsprings,Double budget){
        
        
        for(int i = 0 ; i < parents.size();i++){
            if(parents.get(i).fitness_function > budget){
                if(offsprings.size()>1){
                    parents.remove(i);
                    parents.add(offsprings.get(0));
                    parents.add(offsprings.get(1));
                    if(!offsprings.isEmpty()){
                        offsprings.remove(0);
                        if(!offsprings.isEmpty()){
                             offsprings.remove(0);
                        }
                    } 
                }
            }
            
        }
        if(!offsprings.isEmpty()){
            for(int i = 0 ; i  < offsprings.size();i++){
                
                parents.add(offsprings.get(i));
                    
            }
        }
        return parents;
    }
    public static boolean check(ArrayList<chrom>population,double budget){
        for(int i = 0 ; i < population.size() ; i++){
            if(population.get(i).fitness_function<budget){
                return true;
            }
        }
        return false;
    }
}
