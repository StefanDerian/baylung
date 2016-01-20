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
public class fitness_function {
    ArrayList<medicine> medicines;
    public fitness_function(ArrayList<medicine> medicines){
        this.medicines = medicines;
    }
    public double calculate(ArrayList<Integer> single_encoded){
        double price = 0;
        for(int i = 0 ; i<single_encoded.size();i++){
            price = price + (medicines.get(i).price * single_encoded.get(i));
        }
        return price;
    }
    
    
    
}
