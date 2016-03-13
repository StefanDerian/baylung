/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benny
 */
public class Selection {
    
    ArrayList<Double>probabilities;
    ArrayList<Double>accumulate;
    ArrayList<chrom> population;
    double total_fitness;
    
    
    public  ArrayList<chrom> RWS(ArrayList<chrom> population){
        this.population = population;
        this.total_fitness = sum_fitness();
        this.probabilities = new ArrayList<Double>();
        this.accumulate = new ArrayList<Double>();
        calculate_probability();
        accumulate_probability();
        return select();
    }
    
    public void calculate_probability(){
        for(int i = 0 ; i < this.population.size();i++){
            probabilities.add(this.population.get(i).fitness_function/total_fitness);
        }
    }
    public void accumulate_probability(){
        double accumulated_prob = 0 ; 
        for(int i = 0 ; i< probabilities.size();i++){
            accumulated_prob += probabilities.get(i);
            accumulate.add(accumulated_prob);
        }
    }
    public ArrayList<chrom> select(){
        ArrayList<chrom> selected = new ArrayList<chrom>();
        Random r = new Random();
        for(int i = 0 ; i < population.size();i++){
            double randomized = r.nextDouble();
            for(int j = 0 ; j <accumulate.size();j++){
                if(randomized < accumulate.get(j)){
                    if(!selected.contains(population.get(j))){
                        selected.add(population.get(j));
                        break;
                    }
                }
            }
        }
        if(selected.size() == 1){
            return this.population;
        }
        return selected;
    }
    public double sum_fitness(){
        double total = 0;
        for(int i = 0 ; i<population.size();i++){
            total+=population.get(i).fitness_function;
        }
        return total;
    }
}
