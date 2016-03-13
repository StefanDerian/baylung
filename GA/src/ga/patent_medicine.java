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
public class patent_medicine extends generic_medicine {
    
    
   public String patent_id;public String patent_name;public double patent_price;public String patentExplaination;
    
    public patent_medicine(String generic_id, String generic_name, double generic_price,String patent_id, String patent_name, double patent_price,String patentExplaination) {
        super(generic_id, generic_name, generic_price);
        this.patent_id = patent_id;
        this.patent_name = patent_name;
        this.patent_price = patent_price;  
        this.patentExplaination = patentExplaination;
    }
    
    
    
    
    
    
}
