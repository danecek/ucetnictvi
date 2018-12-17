/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.model;

import java.io.Serializable;

/**
 *
 * @author danecek
 */
public class AbstractId<T extends AbstractId> implements Comparable<T>, Serializable {
    
    private final int id;

    public AbstractId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) return false;
        if (getClass() != that.getClass()) return false;
        T thatId = (T) that;
        return compareTo(thatId)==0;   
               
    }

    @Override
    public int hashCode() {
        return id;//super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
   

    @Override
    public int compareTo(T that) {
        return id-that.getId();        
    }  

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
        
}
