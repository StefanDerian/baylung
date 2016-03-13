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
public class Linguistic {
    public String id;
    public String name;
    public String type;
    public String explaination;
    public Linguistic(String id, String name,String type,String explaination){
        this.id = id;
        this.name = name;
        this.type = type;
        this.explaination = explaination;
        
    }
    public void setUpdate(String name, String type, String explaination){
        this.name = name;
        this.type = type;
        this.explaination = explaination;
        
    }
    
}
