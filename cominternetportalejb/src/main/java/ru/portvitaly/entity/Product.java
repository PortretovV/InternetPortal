package ru.portvitaly.entity;


import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String article;
    private int count;
    private int cost;

    public Product(){}

    public Product(String article, int count, int cost) {
        this.id = 0;
        this.article = article;
        this.count = count;
        this.cost = cost;
    }

    public Product(int id, String article, int count, int cost) {
        this.id = id;
        this.article = article;
        this.count = count;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
