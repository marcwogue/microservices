package com.formation.orderservice.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "customer", nullable = false, length = 100)
    private String costumer;
    @Column(nullable = false, length = 100)
    private String product;
    @Column(nullable = false)
    private int quantity;
    @Column(name = "create_at", nullable = false)
    private Instant createAt;
    @Column(name = "mail", nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private OrderStatus status;

    protected  Order() {}

    public Order( String costumer, String product, int quantity, String email) {
        this.costumer = costumer;
        this.product = product;
        this.quantity = quantity;
        this.createAt = Instant.now() ;
        this.email = email;
        this.status = OrderStatus.CREATED;
    }


    public UUID getId() {
        return id;
    }

    public String getCostumer() {
        return costumer;
    }

    public void setCostumer(String costumer) {
        this.costumer = costumer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }
}
