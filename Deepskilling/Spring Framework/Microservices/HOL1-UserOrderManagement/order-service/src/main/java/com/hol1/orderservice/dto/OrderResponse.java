package com.hol1.orderservice.dto;

import com.hol1.orderservice.model.Order;

public class OrderResponse {
    private Order order;
    private UserResponse user;

    public OrderResponse() {}

    public OrderResponse(Order order, UserResponse user) {
        this.order = order;
        this.user = user;
    }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public UserResponse getUser() { return user; }
    public void setUser(UserResponse user) { this.user = user; }
}
