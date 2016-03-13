/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import static ga.Crossover.onePoint;
import static ga.Crossover.uniform;
import static ga.Mutation.random_point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import tuples.tuples;


/**
 *
 * @author Benny
 */
public class GA {

    /**
     * @param args the command line arguments
     */
    public static chrom get_best_chromosomes(ArrayList<chrom> population){
        chrom selectedChrom = population.get(0);
        double lowestFitness = population.get(0).fitness_function ;
        for(int i = 0 ; i <population.size();i++){
            if(population.get(i).fitness_function<=lowestFitness){
                selectedChrom = population.get(i);
                lowestFitness = population.get(i).fitness_function;
            }
        }
        
        return selectedChrom;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        int generation = 0;
        double budget = 80000;
        double pc = 0.6;
        Random crossoverRand = new Random();
        ArrayList<generic_medicine> GM;
        GM = new ArrayList<generic_medicine>();
       
        GM.add(new generic_medicine("7","ambroxol",10000));
        GM.add(new generic_medicine("9","aminofilin",10000));
        GM.add(new generic_medicine("15","paracetamol",10000));
        ArrayList<chrom> population = new ArrayList<chrom>();
        init i = new init(GM);
        i.print_PM();
        System.out.println();
        i.print_chromosomes();
        generation_updaate gu = new generation_updaate();
        while(generation<=1000){
            System.out.println("------------------iteration-------");
            Selection s = new Selection();
            System.out.println();
            population = s.RWS(i.population);
            ArrayList<chrom> parents = population;
            ArrayList<chrom> offsprings = new ArrayList<chrom>();
            i.print_population(population);
            System.out.print(population.size()+" ");
            int populationnumber = population.size();
            for(int in = 0 ; in < populationnumber-1;in++){
            
                if(crossoverRand.nextDouble() <pc){
                    tuples<chrom,chrom> tc = uniform(population.get(in),population.get(in+1),0.5);
                    chrom c1 = tc.x ;
                    chrom c2 = tc.y ;
                    population.add(c2);
                    population.add(c1);
                    offsprings.add(c1);
                    offsprings.add(c2); 
                }
            
            }
            System.out.println();
            System.out.println();
            i.print_population(population);
            populationnumber = population.size();
            for(int in = 0 ; in < populationnumber;in++){
            
                population.get(in).set_index(random_point(population.get(in)));
            
            }
            System.out.println();
            i.print_population(population);
            
            population = gu.steadyUpdate(parents,offsprings,(double)budget);
            i.print_population(population);
            generation++;
        }
        
        System.out.println("--------result---------------");
        chrom best = get_best_chromosomes(population);
        System.out.println(best.fitness_function);
        for(int in = 0 ; in<best.index.size();in++){
            System.out.print(best.index.get(in)+" ");
            
        }
        System.out.println();
        i.print_PM();
        
        
        
        
        
        
        
    }
    
}
