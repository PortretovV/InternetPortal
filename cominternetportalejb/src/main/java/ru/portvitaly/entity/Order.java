package ru.portvitaly.entity;


import java.io.Serializable;

public class Order implements Serializable{
    private int id;
    private String article;
    private int cost;
    private int width;
    private int height;
    private int length;

    public Order(){}

    public Order(String article, int cost, int width, int height, int length) {
        this.id = 0;
        this.article = article;
        this.cost = cost;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Order(int id, String article, int cost, int width, int height, int length) {
        this.id = id;
        this.article = article;
        this.cost = cost;
        this.width = width;
        this.height = height;
        this.length = length;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
