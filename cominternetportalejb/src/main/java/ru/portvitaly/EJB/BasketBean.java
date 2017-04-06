package ru.portvitaly.EJB;

import ru.portvitaly.DAO.OrderDao;
import ru.portvitaly.DAO.ProductDao;
import ru.portvitaly.DAO.PurchaseDao;
import ru.portvitaly.entity.Lot;
import ru.portvitaly.entity.Order;
import ru.portvitaly.entity.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.NamingException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Stateful
@ConversationScoped
@Named(value = "Basket")
public class BasketBean implements BasketLocalInterface, Serializable {

    @EJB
    OrderDao orderDao;
    @EJB
    PurchaseDao purchaseDao;
    @EJB
    ProductDao q;

    @Inject
    private Conversation conversation;

    private List<Lot> goods = new ArrayList<>();
    private Order order;
    private Product product = new Product();

    public List<Lot> getGoods() {
        return goods;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @PostConstruct
    private void init(){
        if(conversation.isTransient())
            conversation.begin();
    }

    @PreDestroy
    private void destroy(){
        conversation.end();
    }

    public void addProduct(Product product, int countProduct){
        this.goods.add(new Lot(product,countProduct));
    }


    public String detail(int id){
        try {
            product = q.getProductById(id);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return "detail";
    }



    public void deleteProduct(Lot lot){
        this.goods.remove(lot);
    }

    public void editProduct(Lot oldLot, int count){
        oldLot.setCount(count);
    }

    private void createOrder(){
        if(this.goods.isEmpty())
            return;
        Random r = new Random();
        int width = 700 - r.nextInt(10);
        int lenght = 1000 - r.nextInt(10);
        int height = 400 - r.nextInt(10);
        int count = goods.size();
        String article = UUID.randomUUID().toString().substring(0,45);
        int cost = 0;
        for (Lot l : goods) {
            cost += l.getProduct().getCost();
        }

        this.order = new Order(article, cost, width*count, height*count, lenght*count);
    }

    private int createPurchase(){
        if(goods.isEmpty() || order == null)
            return 0;

        //OrderDao orderDao = new OrderDaoImpl();
        //PurchaseDao purchaseDao = new PurchaseDaoImpl();
        try {
            this.order = orderDao.addOrder(order);
            int result = purchaseDao.addPurchase(goods,order);
            if(result == 1){
                destroy();
                return 1;
            }


        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int buyProducts(){
        createOrder();
        return createPurchase();
    }

}

