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
public class antecedent_user {
    public String id;
    public Double CF;
    public String from_rule;
    boolean sure;
    public antecedent_user(String id ,Double CF, String Rule, boolean sure){
        this.id = id;
        this.CF = CF;
        this.from_rule = Rule;
        this.sure = sure;
    }
}
