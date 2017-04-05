package ru.portvitaly.EJB;

import ru.portvitaly.DAO.ProductDao;
import ru.portvitaly.entity.Product;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named(value = "QueryEJB")
public class QueryBean implements  Serializable {
    @EJB
    ProductDao productDao;
    @EJB
    BasketBean basketBean;

    public List<Product> getProducts() {
        this.products = allProducts();
        return products;
    }

    List<Product> products;

    private Product product;
    public Product getProduct() {
        return product;
    }

    private int productCount;
    public int getProductCount() {
        return productCount;
    }
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public List<Product> allProducts(){
        List<Product> products = new ArrayList<>();

        try {
            products = productDao.allProducts();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product productById(int id)  {
        Product p = null;
        try {
            p = productDao.getProductById(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return p;
    }

    public String addToBasket(Product product, int countProduct){
        basketBean.addProduct(product, countProduct);
        return "index";
    }

    public String buyProducts(){
        int result = basketBean.buyProducts();
        if(result == 1 )
            return "success";
        else
            return "failed";
    }

    public String detail(int id){
        this.product = productById(id);
        return "detail";
    }

}
