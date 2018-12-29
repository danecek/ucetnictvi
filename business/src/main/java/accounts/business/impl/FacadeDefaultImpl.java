/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.business.impl;

import accounts.integration.ReaderDAO;
import accounts.model.Account;
import accounts.util.LibException;
import java.util.List;
import accounts.business.Facade;
import accounts.model.AccountId;
import accounts.model.AccountGroup;
import java.math.BigInteger;

public class FacadeDefaultImpl implements Facade {

    @Override
    public void createReader(AccountGroup skupina, int no, String name) throws LibException {
        ReaderDAO.getInstance().create(skupina, no, name);
    }

    @Override
    public List<Account> getAllAccounts() throws LibException {
        List<Account> result = ReaderDAO.getInstance().getAll();
        return result;
    }

    @Override
    public void deleteReaders(List<AccountId> ids) throws LibException {
        for (AccountId id : ids) {
            ReaderDAO.getInstance().delete(id);
        }
    }

}
