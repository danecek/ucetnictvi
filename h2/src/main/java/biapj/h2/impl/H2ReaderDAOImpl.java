/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biapj.h2.impl;

import biapj.integration.ReaderDAO;
import biapj.model.Address;
import biapj.model.LibReader;
import biapj.model.ReaderId;
import biapj.util.LibException;
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

    @Override
    public void create(String name, Address adr) throws LibException {
        try {
            createPs.setString(1, name);
            createPs.setString(2, adr.toString());
            createPs.execute();
        } catch (SQLException ex) {
            throw new LibException(ex);
        }
    }

    @Override
    public List<LibReader> getAll() throws LibException {
         try {
            List<LibReader> readers = new ArrayList<>();
            ResultSet rs = getAllPs.executeQuery();
            while (rs.next()) {
                readers.add(new LibReader(rs.getInt(1), rs.getString(2), new Address(rs.getString(3))));
            }
            return readers;
        } catch (SQLException ex) {
            throw new LibException(ex);
        }
    }
    private static final Logger LOG = Logger.getLogger(H2ReaderDAOImpl.class.getName());

    @Override
    public void delete(ReaderId id) throws LibException {
        try {
            deletePs.setInt(1, id.getId());
            deletePs.execute();
        } catch (SQLException ex) {
            throw new LibException(ex);

        }
    }

    public void close() {
        try {
            createPs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(H2ReaderDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
