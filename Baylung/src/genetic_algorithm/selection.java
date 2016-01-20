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
public class selection {
    
    ArrayList<chromosomes> chromosomes;
    ArrayList<chromosomes> selected;
    ArrayList<Double>accumulation;
    ArrayList<Double>probabilities;
    double FitnessSum = 0;
    fitness_function f;
    public selection(ArrayList<chromosomes> encoded, fitness_function f){
        this.accumulation = new ArrayList<Double>();
        this.probabilities = new ArrayList<Double>();
        this.chromosomes = new ArrayList<chromosomes>();
        this.chromosomes = encoded;
        this.f = f;
        sum_fitness();
        set_probability();
        accumulate();
        to_select();
    }
    public void sum_fitness(){
        for(int i = 0 ; i <chromosomes.size();i++){
            
            FitnessSum += chromosomes.get(i).get_fitness_value();
        }
    }
    public void set_probability(){
       for(int i = 0 ;i <chromosomes.size();i++){
           probabilities.add(chromosomes.get(i).get_fitness_value()/FitnessSum);
       }
    }
    public void accumulate(){
        
        accumulation.add(0.0);
        for(int i= 0 ; i < probabilities.size();i++){
            accumulation.add(probabilities.get(i));
        }
    }
    public void to_select(){
        
        for(int i = 0 ; i <chromosomes.size();i++){
            Random r = new Random();
            double randomized = r.nextDouble();
            for(int j = 0 ; j < accumulation.size();j++){
                if(randomized <= accumulation.get(j)){
                    if(!selected.contains(chromosomes.get(j-1))){
                        selected.add(chromosomes.get(j-1));
                    }
                    break;
                }
            }
        }
        if(selected.size()==1){
            selected = chromosomes;
        }
        
        
    }
            
     public ArrayList<chromosomes> get_selection(){
        return this.selected;
    }
    
    
    
    
}
