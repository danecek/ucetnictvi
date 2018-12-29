package accounts.h2.impl;

import accounts.integration.ReaderDAO;
import accounts.model.Address;
import accounts.model.Account;
import accounts.model.AccountId;
import accounts.model.AccountGroup;
import accounts.util.LibException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class H2ReaderDAOImpl extends ReaderDAO {

    private PreparedStatement createPs;
    private PreparedStatement getAllPs;
    private PreparedStatement deletePs;
    private Connection conn;

    public H2ReaderDAOImpl() {
        try {
            new org.h2.Driver();
            conn = DriverManager.getConnection("jdbc:h2:~/Vyuka/apj/Lib2018H2DB", "sa", "");
            createPs = conn.prepareStatement("insert into READERS values(default, ?, ?)");
            getAllPs = conn.prepareStatement("select * from READERS");
            deletePs = conn.prepareStatement("delete from READERS where id = ?");
        } catch (SQLException ex) {
            Logger.getLogger(H2ReaderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public void create(String name, Address adr) throws LibException {
//        try {
//            createPs.setString(1, name);
//            createPs.setString(2, adr.toString());
//            createPs.execute();
//        } catch (SQLException ex) {
//            throw new LibException(ex);
//        }
//    }
    @Override
    public List<Account> getAll() throws LibException {
        try {
            List<Account> readers = new ArrayList<>();
            ResultSet rs = getAllPs.executeQuery();
            while (rs.next()) {
   //             readers.add(new Account(rs.getInt(1),   rs.getString(2)));
            }
            return readers;
        } catch (SQLException ex) {
            throw new LibException(ex);
        }
    }
    private static final Logger LOG = Logger.getLogger(H2ReaderDAOImpl.class.getName());

//    @Override
//    public void delete(AcountId id) throws LibException {
//        try {
//            deletePs.setInt(1, id.getId());
//            deletePs.execute();
//        } catch (SQLException ex) {
//            throw new LibException(ex);
//
//        }
//    }

    public void close() {
        try {
            createPs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(H2ReaderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void delete(AccountId id) throws LibException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void create(AccountGroup skupina, int no, String name) throws LibException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
