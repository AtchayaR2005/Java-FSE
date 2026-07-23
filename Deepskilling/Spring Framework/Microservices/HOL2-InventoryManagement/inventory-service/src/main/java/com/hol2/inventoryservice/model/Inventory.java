package com.hol2.inventoryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Integer quantity;
    private String warehouse;
    private String status;

    public Inventory() {}
    public Inventory(Long productId, Integer quantity, String warehouse) {
        this.productId = productId; this.quantity = quantity; this.warehouse = warehouse; this.status = "IN_STOCK";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getWarehouse() { return warehouse; }
    public void setWarehouse(String warehouse) { this.warehouse = warehouse; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
