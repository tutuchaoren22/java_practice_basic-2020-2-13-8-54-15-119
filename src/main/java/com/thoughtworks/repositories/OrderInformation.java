package com.thoughtworks.repositories;

public class OrderInformation {
    private String order;

    public OrderInformation(String order) {
        this.order = order;
    }

    public OrderInformation() {}

    public String getOrder() {
        return order;
    }
}
