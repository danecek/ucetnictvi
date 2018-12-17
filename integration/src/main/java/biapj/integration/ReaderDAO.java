package biapj.integration;

import biapj.integration.impl.ReaderDAODefault;
import biapj.model.Address;
import biapj.model.LibReader;
import biapj.model.ReaderId;
import biapj.util.LibException;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.logging.Logger;

public abstract class ReaderDAO {

    private static ReaderDAO instance = null;

    public static ReaderDAO getInstance() {
        if (instance == null) {
            Optional<ReaderDAO> os = ServiceLoader.load(ReaderDAO.class).findFirst();

            if (os.isPresent()) {
                instance = os.get();
            } else {
                instance = new ReaderDAODefault();
            }
        }
        LOG.info(instance.toString());
        return instance;
    }
    private static final Logger LOG = Logger.getLogger(ReaderDAO.class.getName());

    public abstract void create(String name, Address adr) throws LibException;

    public abstract List<LibReader> getAll() throws LibException;

    public abstract void delete(ReaderId id) throws LibException;

}
