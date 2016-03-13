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
public class Mutation {
    public static ArrayList<Integer> random_point(chrom c){
        Random r = new Random();
        ArrayList<Integer> newchrom = new ArrayList<Integer>();
        for(int i = 0 ;i<c.index.size();i++){
            double rate = r.nextDouble();
            
            if(rate < (double)(1/(double)c.index.size())){
                
                int value = r.nextInt(c.PM.get(i).size() - 1);
                newchrom.add(value);
            }else{
                newchrom.add(c.index.get(i));
            }
        }
        return newchrom;
    }
}
