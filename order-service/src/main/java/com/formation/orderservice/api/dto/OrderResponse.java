package com.formation.orderservice.api.dto;

import com.formation.orderservice.domain.Order;
import jakarta.persistence.criteria.From;

import java.time.Instant;
import java.util.UUID;

public record OrderResponse(
        UUID id, String costumer, String product, Instant createdAt , int quantity, String email
) {

    public  static OrderResponse from(Order order){
        return  new OrderResponse(
                order.getId(),
                order.getCostumer(),
                order.getProduct(),
                order.getCreateAt(),
                order.getQuantity(),
                order.getEmail()
        );
    }
}
