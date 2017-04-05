import ru.portvitaly.DAO.ProductDao;
import javax.faces.bean.ManagedBean;

import ru.portvitaly.EJB.BasketBean;
import ru.portvitaly.EJB.QueryBean;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;
import ru.portvitaly.entity.Product;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@SessionScoped
public class ProductManage implements Serializable {

    private List<Product> products = new ArrayList<>();
    private Product product = new Product();
    private int productCount;

    @EJB
    ProductDao q;

    private BasketBean basketBean = new BasketBean();

    public List<Product> getProducts() {
        try {
            this.products = q.allProducts();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
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

    public String index(){
        return "index";
    }

    public String basket(){
        return "basket";
    }


    public String buyProducts(){
        int result = basketBean.buyProducts();
        if(result == 1 )
            return "success";
        else
            return "failed";
    }

    public String detail(int id){
        try {
            product = q.getProductById(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return "detail";
    }

    public String addToBasket(Product product, int countProduct){
        basketBean.addProduct(product, countProduct);
        return "index";
    }


}
