package ru.portvitaly.DAO;

import ru.portvitaly.entity.Order;

import javax.ejb.Remote;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Remote
public interface OrderDao {

    List<Order> allOrders() throws SQLException, NamingException;

    Order addOrder(Order order) throws SQLException, NamingException;

    void deleteOrder(int idOrder) throws SQLException, NamingException;

    Order updateOrder(Order order) throws SQLException, NamingException;

    Order getOrderById(int idOrder) throws SQLException, NamingException;
}
