/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Benny
 */
public class question {
   public String id;
   public String question;
   public String type;
   public String linguistic_id;
   public String linguistic_name;
    
    public question(String id, String question, String type, String linguistic_name,String linguistic_id){
        this.id = id;
        this.question = question;
        this.type = type;
        this.linguistic_id = linguistic_id;
        this.linguistic_name =linguistic_name;
    }
    public void updateQuestion( String question, String type,String linguistic_name, String linguistic_id){
        this.question = question;
        this.type = type;
        if(linguistic_id !=""){
            this.linguistic_id = linguistic_id;
        }
        if(linguistic_name !=""){
            this.linguistic_name = linguistic_name;
        }
        
        
    }
}
