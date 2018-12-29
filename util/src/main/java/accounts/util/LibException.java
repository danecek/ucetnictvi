/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.util;


/**
 *
 * @author danecek
 */
public class LibException extends Exception {

    public LibException(String message) {
        super(message);
    }

    public LibException(Exception cause) {
     super(cause);
    }
    
    
}
