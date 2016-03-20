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
public class Rule {
    public String id;
    public String linguisticId;
    public String linguisticName;
    public String CF;
    
    
    public Rule(String id,String linguisticId,String linguisticName,String CF){
        this.id = id;
        this.linguisticId = linguisticId;
        this.linguisticName = linguisticName;
        this.CF = CF;
    }
    public void updateRule(String linguisticId,String linguisticName,String CF){
        this.linguisticId = linguisticId;
        this.linguisticName = linguisticName;
        this.CF = CF;
    }
}
