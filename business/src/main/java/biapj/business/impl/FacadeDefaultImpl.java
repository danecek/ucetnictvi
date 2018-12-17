/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.business.impl;

import biapj.integration.ReaderDAO;
import biapj.model.Address;
import biapj.model.LibReader;
import biapj.util.LibException;
import java.util.List;
import biapj.business.Facade;
import biapj.model.ReaderId;
import java.util.logging.Logger;

public class FacadeDefaultImpl implements Facade {

    @Override
    public void createReader(String name, Address adr) throws LibException {
        ReaderDAO.getInstance().create(name, adr);
    }

    @Override
    public List<LibReader> getAllReaders() throws LibException {
        List<LibReader> result = ReaderDAO.getInstance().getAll();
        return result;
    }

    @Override
    public void deleteReaders(List<ReaderId> ids) throws LibException {
        for (ReaderId id : ids) {
            ReaderDAO.getInstance().delete(id);
        }
    }

}
