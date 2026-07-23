package com.hol4.paymentservice.model;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private Long orderId;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate;

    public Payment() {}
    public Payment(Long orderId, Double amount, String paymentMethod) {
        this.orderId = orderId; this.amount = amount; this.paymentMethod = paymentMethod;
        this.status = "PENDING"; this.paymentDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
}
