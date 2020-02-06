package com.orders.management.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Table(name = "Line")
@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int order_id;
    private int user_id;
    @ManyToOne
    @JoinColumn(name="shaurma", nullable=false)
    private ShaurmaType shaurmaTypeId;
    @ManyToMany
    @JoinTable(
            name = "line_spice",
            joinColumns = @JoinColumn(name = "line_ids"),
            inverseJoinColumns = @JoinColumn(name = "spice_ids"))
   //@OneToMany(mappedBy = "course")
   private Set<Spice> spice_id;
    @ManyToMany
    @JoinTable(
            name = "line_additive",
            joinColumns = @JoinColumn(name = "line_ids"),
            inverseJoinColumns = @JoinColumn(name = "additive_ids"))
  // @OneToMany(mappedBy = "additive")
    private Set<Additive> additive_ids;
    private String description;

    public int getOrderId() {
        return order_id;
    }
    public void setOrderid(int order_id) {
        this.order_id = order_id;
    }

    public int getUserId() {
        return user_id;
    }
    public void setUserid(int user_id) {
        this.user_id = user_id;
    }

    public ShaurmaType getShaurmaTypeId() {
        return shaurmaTypeId;
    }
    public void setShaurmaTypeId(ShaurmaType shaurmaTypeId) {
        this.shaurmaTypeId = shaurmaTypeId;
    }

    public Set<Spice> getSpiceid() {
        return spice_id;
    }

    public Set<Additive> getAdditiveIds() {
        return additive_ids;
    }

    public void setAdditiveIds(Set<Additive> additive_Id) {
        this.additive_ids = additive_ids;
    }

    public void setSpiceid(Set<Spice> spice_id) {
        this.spice_id = spice_id;
    }


    public String getDescription() {
        return description;
    }
    public void setDescriptionId(String description) {
        this.description = description;
    }


    public int getId() {
        return id;
    }

}
