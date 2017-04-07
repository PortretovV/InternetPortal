import ru.portvitaly.DAO.ProductDao;
import javax.faces.bean.ManagedBean;
import ru.portvitaly.EJB.BasketLocalInterface;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Product;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductManage implements Serializable {

    @EJB
    private BasketLocalInterface basketBean;
    @EJB
    private ProductDao q;

    private List<Product> products;
    private List<Lot> goods;

    public List<Lot> getGoods() {
        this.goods = basketBean.getGoods();
        return goods;
    }

    private Product product;
    private int productCount;


    //Получение списка товаров
    public List<Product> getProducts() {
        try {
            products = q.allProducts();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct() {
        return product;
    }

    //Запись нужного кол-во товаров для добавления в корзину
    public int getProductCount() {
        return productCount;
    }
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    //Получение детальной информации о товарах
    public String detail(int id){
        try {
            product = q.getProductById(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return "detail";
    }

    public void editProduct(Lot oldLot, int count){
        basketBean.editProduct(oldLot,count);
    }

    public void deleteProduct(Lot lot){
        basketBean.deleteProduct(lot);
    }


    public String buyProducts(){
        int result = basketBean.buyProducts();
        if(result == 1 )
            return "success";
        else
            return "failed";
    }



    public String addToBasket(Product product, int countProduct){
        basketBean.addProduct(product, countProduct);
        return "index";
    }


}
