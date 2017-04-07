package ru.portvitaly.EJB;

import ru.portvitaly.entity.Product;

import java.util.List;

/**
 * Created by VP on 06.04.2017.
 */
public interface QueryBeanInterface {
    List<Product> allProducts();
    Product productById(int id);
}
