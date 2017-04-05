package ru.portvitaly.DAO;

import javax.ejb.Remote;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

@Remote
public interface DaoInterface {
    Connection openConnection() throws SQLException, NamingException;
    void closeConnection() throws SQLException;

}
