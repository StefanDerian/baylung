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
public class mutation {
    
    public static chromosomes randomPoint(chromosomes allele){
        Random r = new Random();
        ArrayList<Integer> newallele = new ArrayList<Integer>() ;
        for(int i = 0 ;i<allele.encoded.size();i++){
           double rate;
           rate = r.nextDouble();
           if(rate < 1/allele.encoded.size()){
               allele.set_value_at_index(i,r.nextInt());
           }
        }
        return allele;
    }
}
