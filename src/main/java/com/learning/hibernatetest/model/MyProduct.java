package com.learning.hibernatetest.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class MyProduct {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "title")
    private String title;

    public MyProduct(Long cost, String title) {
        this.cost = cost;
        this.title = title;
    }

    public MyProduct() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }
    public void setCost(Long cost) {
        this.cost = cost;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}