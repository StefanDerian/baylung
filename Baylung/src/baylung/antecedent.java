/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;

/**
 *
 * @author Benny
 */
public class antecedent {
    String id; 
    int not;
    int connector;

   
    public antecedent(String id ,int not , int connector){
        this.id = id;
        this.not = not;
        this.connector = connector;
    }
}
