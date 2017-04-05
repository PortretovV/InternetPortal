package ru.portvitaly.DAO.Impl;

import ru.portvitaly.DAO.Dao;
import ru.portvitaly.DAO.PurchaseDao;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class PurchaseDaoImpl extends Dao implements PurchaseDao {
    private final String ADD_PURCHASE = " INSERT INTO purchase (id_purchase, id_order, id_product, count) VALUE  (NULL, ?, ?, ?)";

    @Override
    public int addPurchase(List<Lot> products, Order order) throws SQLException, NamingException {
        int resultOperation = 0;

        try {
            openConnection();
            for (Lot l: products ) {
                try(PreparedStatement prepStatement = connection.prepareStatement(ADD_PURCHASE)){
                    prepStatement.setInt(1,order.getId());
                    prepStatement.setInt(2,l.getProduct().getId());
                    prepStatement.setInt(3,l.getCount());

                    resultOperation = prepStatement.executeUpdate();
                }
            }
            if(resultOperation == 1)
                System.out.println("Добавление прошло успешно");

        }finally {
            closeConnection();
        }
        return resultOperation;
    }

}
