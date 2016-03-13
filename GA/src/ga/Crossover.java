/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;
import java.util.ArrayList;
import java.util.Random;
import tuples.tuples;
/**
 *
 * @author Benny
 */
public class Crossover {
    public static tuples<chrom,chrom> onePoint(chrom parent1, chrom parent2,int point){
        chrom offspring1;
        chrom offspring2;
        ArrayList<Integer>offspring1Index = new ArrayList<Integer>();
        ArrayList<Integer>offspring2Index = new ArrayList<Integer>();
        for(int i = 0 ; i <parent1.index.size();i++){
            
            if(i<=point){
                offspring2Index.add(parent1.index.get(i));
                offspring1Index.add(parent2.index.get(i));
            }else{
                offspring1Index.add(parent1.index.get(i));
                offspring2Index.add(parent2.index.get(i));
            }
        }
        offspring1 = new chrom(offspring1Index,parent1.PM);
        offspring2 = new chrom(offspring2Index,parent2.PM);
        return new tuples<chrom,chrom>(offspring1,offspring2);
    }
    public static tuples<chrom,chrom> uniform(chrom parent1, chrom parent2,double probability){
        chrom offspring1;
        chrom offspring2;
        ArrayList<Integer>offspring1Index = new ArrayList<Integer>();
        ArrayList<Integer>offspring2Index = new ArrayList<Integer>();
        Random r  = new Random();
        
        for(int i = 0 ; i <parent1.index.size();i++){
            
            if(r.nextDouble()<=probability){
                offspring2Index.add(parent1.index.get(i));
                offspring1Index.add(parent2.index.get(i));
            }else{
                offspring1Index.add(parent1.index.get(i));
                offspring2Index.add(parent2.index.get(i));
            }
        }
        offspring1 = new chrom(offspring1Index,parent1.PM);
        offspring2 = new chrom(offspring2Index,parent2.PM);
        return new tuples<chrom,chrom>(offspring1,offspring2);
    }
  
    
    
    
    
    
    
}
