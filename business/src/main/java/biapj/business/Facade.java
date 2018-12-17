/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.business;

import biapj.model.Address;
import biapj.model.LibReader;
import biapj.model.ReaderId;
import biapj.util.LibException;
import java.util.List;

public interface Facade {

    void createReader(String name, Address adr) throws LibException;

    List<LibReader> getAllReaders() throws LibException;

    void deleteReaders(List<ReaderId> ids) throws LibException;

}
