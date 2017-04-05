package ru.portvitaly.DAO;

import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;

import javax.ejb.Remote;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Remote
public interface PurchaseDao {

    int addPurchase(List<Lot> products, Order order) throws SQLException, NamingException;
}
