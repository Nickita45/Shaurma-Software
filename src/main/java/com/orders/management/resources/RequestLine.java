package com.orders.management.resources;


import java.util.Set;


public class RequestLine {



    private int order_id;
    private int user_id;
    private int shaurmaTypeId;
    private Set<Integer> spiceIds;
    private Set<Integer> additiveIds;
    private String description;


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getShaurmaTypeId() {
        return shaurmaTypeId;
    }

    public void setShaurmaTypeId(int shaurmaTypeId) {
        this.shaurmaTypeId = shaurmaTypeId;
    }

    public Set<Integer> getSpiceIds() {
        return spiceIds;
    }

    public void setSpiceIds(Set<Integer> spiceIds) {
        this.spiceIds = spiceIds;
    }

    public Set<Integer> getAdditiveIds() {
        return additiveIds;
    }

    public void setAdditiveIds(Set<Integer> additiveIds) {
        this.additiveIds = additiveIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

