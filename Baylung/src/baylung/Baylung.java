/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baylung;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Benny
 */
public class Baylung {
    private static Connection koneksi;
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        try {
            
            ruleProcess RP = new ruleProcess();
            RP.set_rules();
            RP.print_rules();
    } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
        e.printStackTrace();
        } 
        
    }
    
}
