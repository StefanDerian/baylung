/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

/**
 *
 * @author Benny
 */
public class generic_medicine {
    
    public String generic_name;
    public double generic_price;
    public String generic_id;
    
    public generic_medicine(String generic_id,String generic_name,double generic_price){
        this.generic_id = generic_id;
        this.generic_name = generic_name;
        this.generic_price = generic_price;
    }
}
