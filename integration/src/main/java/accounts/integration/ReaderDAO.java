package accounts.integration;

import accounts.integration.impl.AcountDAODefault;
import accounts.model.Account;
import accounts.model.AccountId;
import accounts.model.AccountGroup;

import accounts.util.LibException;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

public abstract class ReaderDAO {

    private static ReaderDAO instance = null;

    public static ReaderDAO getInstance() {
        if (instance == null) {
//            Optional<ReaderDAO> os = ServiceLoader.load(ReaderDAO.class).findFirst();
//            if (os.isPresent()) {
//                instance = os.get();
//            } else
            {
                instance = new AcountDAODefault();
            }
        }
        return instance;
    }
    private static final Logger LOG = Logger.getLogger(ReaderDAO.class.getName());

    public abstract void create(AccountGroup skupina, int no, String name) throws LibException;

    public abstract List<Account> getAll() throws LibException;

    public abstract void delete(AccountId id) throws LibException;

}
