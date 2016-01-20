/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic_algorithm;

import java.util.ArrayList;

/**
 *
 * @author Benny
 */
public class chromosomes {
    double fitness_value;
    ArrayList<Integer> encoded;
    fitness_function f;
    int old = 0;
    public chromosomes(ArrayList<Integer> encoded,fitness_function f){
        this.encoded = encoded;
        this.f = f;
        calculate_value();
    }
    public void calculate_value(){
        this.fitness_value = f.calculate(encoded);
    }
    public void set_value_at_index(int index, int value){
        this.encoded.remove(index);
        this.encoded.add(index, value);
    }
    public void change_encoded(ArrayList<Integer> encoded){
        this.encoded = encoded;
        calculate_value();
    }
    public double get_fitness_value(){
        return fitness_value;
    }
}
