/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.business.bilance;

import accounts.business.FacadeLocator;
import accounts.business.transactions.Transaction;
import accounts.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bilance {

    public List<BilanceItem> createBilance() {
        Map<Account, BilanceItem> bitems = new TreeMap<>();
        for (Account account : FacadeLocator.getInstance().getAllAccounts()) {
            bitems.put(account, new BilanceItem(account));
        }
        for (Transaction t : FacadeLocator.getInstance().getAllTransactions()) {
            BilanceItem dalAccount = bitems.get(t.getDal());
            BilanceItem madatiAccount = bitems.get(t.getMaDati());
            bitems.get(dalAccount).dal += t.getAmount();
            bitems.get(madatiAccount).maDati += t.getAmount();
        }
        return new ArrayList<>(bitems.values());
    }

}
