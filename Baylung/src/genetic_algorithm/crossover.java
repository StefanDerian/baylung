/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic_algorithm;
import java.util.ArrayList;
import java.util.Random;
import tuples.tuples;
/**
 *
 * @author Benny
 */
public class crossover {
    
    
    
    public static tuples<ArrayList<chromosomes>,ArrayList<chromosomes>> onepoint(ArrayList<chromosomes>parent1,ArrayList<chromosomes>parent2,int i) throws MyOwnException{
        if(parent1.size() != parent2.size()){
            throw new MyOwnException("parent size must be the same");
        }
        if(i>parent1.size()){
            throw new MyOwnException("the size must not be larger than parent");
        }
        
        for(int j = i ; j <parent1.size();j++ ){
            chromosomes temp;
            temp = parent2.get(j);
            
            parent2.get(j).change_encoded(parent1.get(j).encoded);
            parent1.get(j).change_encoded(temp.encoded);
            
        }
        
        tuples <ArrayList<chromosomes>,ArrayList<chromosomes>> t = new tuples <>(parent1,parent2);
        
        
        return t;
    }
    public static tuples<ArrayList<chromosomes>,ArrayList<chromosomes>> twopoint(ArrayList<chromosomes>parent1,ArrayList<chromosomes>parent2,int i,int k) throws MyOwnException{
        if(parent1.size() != parent2.size()){
            throw new MyOwnException("parent size must be the same");
        }
        if(i>parent1.size() || k>parent1.size()){
            throw new MyOwnException("the size must not be larger than parent");
        }
        if(k<i){
            throw new MyOwnException("second point must be lower than first point");
        }
        
        for(int j = i ; j <k;j++ ){
            chromosomes temp;
            temp = parent2.get(j);
            
            parent2.get(j).change_encoded(parent1.get(j).encoded);
            parent1.get(j).change_encoded(temp.encoded);
            
        }
        
        tuples <ArrayList<chromosomes>,ArrayList<chromosomes>> t = new tuples <>(parent1,parent2);
        
        
        return t;
    }
    public static tuples<ArrayList<chromosomes>,ArrayList<chromosomes>> custompoint(ArrayList<chromosomes>parent1,ArrayList<chromosomes>parent2,ArrayList<Integer>binary) throws MyOwnException{
        if(parent1.size() != parent2.size()){
            throw new MyOwnException("parent size must be the same");
        }
        if(binary.size() != parent1.size()){
            throw new MyOwnException("binary data must hae the same size");
        }
        
        for(int j = 0 ; j <parent1.size();j++ ){
            
            if(binary.get(j) == 1){
            chromosomes temp;
            temp = parent2.get(j);
            
            parent2.get(j).change_encoded(parent1.get(j).encoded);
            parent1.get(j).change_encoded(temp.encoded);
            }
        }
        
        tuples <ArrayList<chromosomes>,ArrayList<chromosomes>> t = new tuples <>(parent1,parent2);
        return t;
    }
     public static tuples<ArrayList<chromosomes>,ArrayList<chromosomes>> multiparent(ArrayList<ArrayList<chromosomes>>parents) throws MyOwnException{
        ArrayList<chromosomes> parent1 = new ArrayList<chromosomes>();
        ArrayList<chromosomes> parent2 = new ArrayList<chromosomes>();
        Random r = new Random();
        for(int j = 0 ; j <parents.get(0).size();j++ ){
            int randompoint = r.nextInt(parents.size()-1);
            int randompoint2 = r.nextInt(parents.size()-1);
            parent1.add(parents.get(randompoint).get(j));
            parent2.add(parents.get(randompoint2).get(j));
        }
        
        tuples <ArrayList<chromosomes>,ArrayList<chromosomes>> t = new tuples <>(parent1,parent2);
        return t;
    }
    
    
    
}
