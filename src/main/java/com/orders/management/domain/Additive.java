package com.orders.management.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "additive")
public class Additive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id ;

    private String name;
    private double price;
    @ManyToMany(mappedBy = "additive_id")
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
