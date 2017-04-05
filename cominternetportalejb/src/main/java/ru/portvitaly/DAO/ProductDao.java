package ru.portvitaly.DAO;

import ru.portvitaly.entity.Product;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Remote
public interface ProductDao {

    List<Product> allProducts() throws SQLException, NamingException;

    Product getProductById(int idProduct) throws SQLException, NamingException;

//    public Product addProduct(Product product) throws SQLException, NamingException;
//
//    public void deleteProduct(int idProduct) throws SQLException, NamingException;
//
//    public Product updateProduct(Product product) throws SQLException, NamingException;
}
