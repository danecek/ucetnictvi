package accounts.integration.impl;

import accounts.integration.ReaderDAO;
import accounts.model.Account;
import accounts.model.AccountId;
import accounts.model.AccountGroup;
import accounts.util.LibException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.logging.Logger;

public class AcountDAODefault extends ReaderDAO {

    private static final Logger LOG = Logger.getLogger(AcountDAODefault.class.getName());
    static int keyC = 1;

    private final NavigableMap<AccountId, Account> readerMap = new TreeMap<>();

    @Override
    public void create(AccountGroup skupina, int no, String name) throws LibException {
        Account r = new Account(keyC++,  skupina, no, name);
        readerMap.put(r.getId(), r);
    }

    @Override
    public List<Account> getAll() throws LibException {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public void delete(AccountId id) throws LibException {
        readerMap.remove(id);
    }

}
