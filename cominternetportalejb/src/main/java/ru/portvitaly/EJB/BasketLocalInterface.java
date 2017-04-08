package ru.portvitaly.EJB;

import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BasketLocalInterface {
    int buyProducts();
    void addProduct(Product product, int countProduct);
    void deleteProduct(Lot lot);
    void editProduct(Lot lot, int count);
//    List<Product> allProducts();
//    Product productById(int id);
    List<Lot> getGoods();

}
