/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.model;

import java.io.Serializable;

/**
 *
 * @author danecek
 */
public class Address implements Serializable{

    public Address(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }
    private String address;

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
}
