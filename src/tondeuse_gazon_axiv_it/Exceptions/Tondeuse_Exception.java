/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tondeuse_gazon_axiv_it.Exceptions;

/**
 *
 * @author asus
 */
public class Tondeuse_Exception extends Exception {
   
    private static final long serialVersionUID = 1L;
    private String message;

    public Tondeuse_Exception(String m) {
        
        super(m);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
