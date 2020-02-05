package com.orders.management.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long order_id;
    private long user_id;
    private long shaurmaType_id;
    private long spice_id;
    private Set<Long> additive_ids;
    private String description;

    public long getOrderId() {
        return order_id;
    }
    public void setOrderid(long order) {
        this.order_id = order_id;
    }

    public long getUserId() {
        return user_id;
    }
    public void setUserid(long user_id) {
        this.user_id = user_id;
    }

    public long getShaurmaTypeId() {
        return shaurmaType_id;
    }
    public void setShaurmaTypeId(long shaurmaType_id) {
        this.shaurmaType_id = shaurmaType_id;
    }

    public long getSpiceId() {
        return spice_id;
    }
    public void setSpiceId(long spice_id) {
        this.spice_id = spice_id;
    }

    public Set<Long> getAdditiveId() {
        return additive_ids;
    }
    public void setAdditiveId(long id) {
        additive_ids.add(id);
    }


    public String getDescription() {
        return description;
    }
    public void setDescriptionId(String description) {
        this.description = description;
    }


    public long getId() {
        return id;
    }

}
