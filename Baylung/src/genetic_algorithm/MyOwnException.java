/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genetic_algorithm;

/**
 *
 * @author Benny
 */
class MyOwnException extends Exception {

    public MyOwnException(String parent_size_must_be_the_same) {
        System.out.print(parent_size_must_be_the_same);
    }
    
}
