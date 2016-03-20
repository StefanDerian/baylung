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
public class antecedent {
    public String id;
    public String linguisticId;
    public String Not;
     public String ruleId;
     public String Connector;
     public String linguisticName;
    public antecedent(String id,String linguisticId,String ruleId,String linguisticName,String Not, String Connector ){
        this.id = id;
        this.linguisticId =linguisticId;
        this.Not = Not;
        this.ruleId = ruleId;
        this.Connector = Connector;
        this.linguisticName = linguisticName;
    }
    public void updateAntecedent(String linguisticId,String linguisticName,String Not, String Connector){
        this.linguisticId =linguisticId;
        this.Not = Not;
        
        this.Connector = Connector;
        this.linguisticName = linguisticName;
    }
}
