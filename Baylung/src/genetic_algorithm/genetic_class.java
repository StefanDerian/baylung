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
public class genetic_class {
    double pc;
    double pm;
    double budget;
    ArrayList<medicine> Medicines;
    ArrayList<chromosomes> encoded;
    int sample_number = 6;
    fitness_function f;
    public genetic_class (double budget, ArrayList<medicine> Medicines){
        this.Medicines = Medicines;
        this.budget = budget;
        this.encoded = new ArrayList<chromosomes>();
        this.f = new fitness_function(Medicines);
        Random r =new Random();
        
    }
    
    public void encode(){
        for(int i = 0;i<sample_number;i++){
            ArrayList<Integer> single_medicine = new ArrayList<Integer>();
            
            for(int j = 0 ;j<this.Medicines.size();j++){
                Random r = new Random();
                single_medicine.add(r.nextInt(20));
            }
            chromosomes c = new chromosomes(single_medicine,f);
            this.encoded.add(c);
        }  
    }
}
