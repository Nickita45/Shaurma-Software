package com.orders.management.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Spice")
public class Spice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private double price;
    @ManyToMany(mappedBy = "spice_id")
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


    public long getId() {
        return id;
    }
}
