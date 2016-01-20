/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic_algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benny
 */
public class generation_update {
    public static ArrayList<chromosomes> continous_update(ArrayList<chromosomes> parents,ArrayList<chromosomes>offsprings){
        Random r = new Random();
        ArrayList<chromosomes> c =new ArrayList<chromosomes>();
        for(int i = 0 ; i<parents.size();i++){
            double rate = r.nextDouble();
            double prob = 0.5;
            if(rate<=prob){
                parents.get(i).old++;
                c.add(parents.get(i));
            }
        }
        for(int i = 0 ; i<offsprings.size();i++){
            double rate = r.nextDouble();
            double prob = 0.5;
            if(rate<=prob){
                offsprings.get(i).old++;
                c.add(offsprings.get(i));
            }
        }
        return c;
    
    }
    public static ArrayList<chromosomes> steady_update(ArrayList<chromosomes> parents,ArrayList<chromosomes>offsprings,double limit,int number){
        Random r = new Random();
        ArrayList<chromosomes> c =new ArrayList<chromosomes>();
        int increment = 0;
        for(int i = 0 ; i<parents.size();i++){
            if(parents.get(i).get_fitness_value()<limit){
                if(parents.get(i).old<3){
                    parents.get(i).old++;
                    c.add(parents.get(i));
                }
            }
        }
        for(int i = 0 ; i<offsprings.size();i++){
            if(offsprings.get(i).get_fitness_value()<limit){
               c.add(offsprings.get(i));
               offsprings.get(i).old++;
            }
        }
        return c;
    }
    
}
