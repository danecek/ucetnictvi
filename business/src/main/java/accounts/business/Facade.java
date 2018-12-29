/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.business;

import accounts.business.transactions.Transaction;
import accounts.model.Account;
import accounts.model.AccountId;
import accounts.model.AccountGroup;
import accounts.util.LibException;
import java.util.List;

public interface Facade {

    void createReader(AccountGroup skupina, int no, String name) throws LibException;

    List<Account> getAllAccounts() throws LibException;

    void deleteReaders(List<AccountId> ids) throws LibException;

    List<Transaction> getAllTransactions() throws LibException;

}
