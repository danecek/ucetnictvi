package biapj.integration.impl;

import biapj.integration.ReaderDAO;
import biapj.model.Address;
import biapj.model.LibReader;
import biapj.model.ReaderId;
import biapj.util.LibException;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.logging.Logger;

public class ReaderDAODefault extends ReaderDAO {

    private static final Logger LOG = Logger.getLogger(ReaderDAODefault.class.getName());
    static int keyC = 1;

    private NavigableMap<ReaderId, LibReader> readerMap = new TreeMap<>();

    @Override
    public void create(String name, Address adr) throws LibException {
        LibReader r = new LibReader(keyC++, name, adr);
        readerMap.put(r.getId(), r);
    }

    @Override
    public List<LibReader> getAll() throws LibException {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public void delete(ReaderId id) throws LibException {
        readerMap.remove(id);
    }

}
