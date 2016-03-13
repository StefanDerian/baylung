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
public class chrom {
    public ArrayList<Integer>index;
    public double fitness_function;
    int old = 0 ;
    public ArrayList<ArrayList<patent_medicine>>PM;
    public chrom(ArrayList<Integer>index,ArrayList<ArrayList<patent_medicine>>PM ){
        this.index = index;
        this.PM = PM;
        this.fitness_function = calculate_fitness(this.PM);
    }
    public void increment_old(){
        old++;
    }
    public double calculate_fitness(ArrayList<ArrayList<patent_medicine>>PM){
        double price = 0;
        for(int i = 0 ; i<PM.size();i++){
            price += PM.get(i).get(index.get(i)).patent_price;
            
        }
        return price;
    }
    public void update_fitness(){
        this.fitness_function = calculate_fitness(PM);
    }
    public void set_value_at_index(int i,int value){
        this.index.remove(i);
        this.index.add(i, value);
        update_fitness();
    }
    public void set_index(ArrayList<Integer>index){
        this.index =index; 
        update_fitness();
    }
    
    
}
