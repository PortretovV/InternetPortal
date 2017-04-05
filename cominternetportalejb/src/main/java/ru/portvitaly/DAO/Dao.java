package ru.portvitaly.DAO;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;

@Stateless
public class Dao implements DaoInterface {

    @Resource(name="jdbc/my_cklad")
    protected  DataSource dataSource;
    protected Connection connection;

    public Dao() {
        super();
    }

    @PostConstruct
    public void init() {
        Context ctx = null;
        try {
            ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/my_shop");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public Connection openConnection() throws SQLException {
         connection = dataSource.getConnection();
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }
}