package com.orders.management.domain;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Additive")
public class Additive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double price;
    @OneToMany(mappedBy = "additive_ids")
    private Set<Line> line_ids;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }
}
