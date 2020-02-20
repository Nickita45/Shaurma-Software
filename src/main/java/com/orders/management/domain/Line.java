package com.orders.management.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "line")
@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@OneToMany(mappedBy="id")
    //@JoinColumn(name="order_id", unique = true, nullable = false, updatable = false)

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
            //(cascade = CascadeType.ALL, mappedBy = "lines", fetch = FetchType.EAGER)
    private Document order_id;

    //@OneToOne(mappedBy="userId")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="shaurma")
    private ShaurmaType shaurmaTypeId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "line_spice",
            joinColumns = @JoinColumn(name = "line_ids"),
            inverseJoinColumns = @JoinColumn(name = "spice_ids"))
   private Set<Spice> spice_id;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "line_additive",
            joinColumns = @JoinColumn(name = "line_ids"),
            inverseJoinColumns = @JoinColumn(name = "additive_ids"))
    private Set<Additive> additive_id;
    private String description;

    public Document getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Document order_id) {
        this.order_id = order_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public ShaurmaType getShaurmaTypeId() {
        return shaurmaTypeId;
    }

    public void setShaurmaTypeId(ShaurmaType shaurmaTypeId) {
        this.shaurmaTypeId = shaurmaTypeId;
    }

    public Set<Spice> getSpice_id() {
        return spice_id;
    }

    public void setSpice_id(Set<Spice> spice_id) {
        this.spice_id = spice_id;
    }

    public Set<Additive> getAdditive_ids() {
        return additive_id;
    }

    public void setAdditive_ids(Set<Additive> additive_id) {
        this.additive_id = additive_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

}
