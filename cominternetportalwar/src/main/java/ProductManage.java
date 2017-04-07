import ru.portvitaly.DAO.ProductDao;
import javax.faces.bean.ManagedBean;

import ru.portvitaly.EJB.BasketLocalInterface;
import ru.portvitaly.entity.Product;


import javax.ejb.EJB;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class ProductManage implements Serializable {

    @EJB
    private BasketLocalInterface basketBean;
    @EJB
    private ProductDao q;

    private List<Product> products = new ArrayList<>();
    private Product product = new Product();
    private int productCount;

    //Получение списка товаров
    public List<Product> getProducts() {
        products = basketBean.allProducts();
        return products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Product productById(int id)  {
        Product p = null;
        try {
            p = q.getProductById(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return p;
    }


    public String buyProducts(){
        int result = basketBean.buyProducts();
        if(result == 1 )
            return "success";
        else
            return "failed";
    }

    public String detail(int id){
        product = basketBean.productById(id);
        return "detail";
    }

    public String addToBasket(Product product, int countProduct){
        basketBean.addProduct(product, countProduct);
        return "index";
    }


}
