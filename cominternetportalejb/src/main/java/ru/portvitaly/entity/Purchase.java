package ru.portvitaly.entity;

import java.io.Serializable;

public class Purchase implements Serializable {
    private int idPurchase;
    private int idOrder;
    private int idProduct;
    private int count;
    private Order order;
    private Product product;

    public Purchase() {}

    public Purchase(int idPurchase, int idOrder, int idProduct, int count) {
        this.idPurchase = idPurchase;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.count = count;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
