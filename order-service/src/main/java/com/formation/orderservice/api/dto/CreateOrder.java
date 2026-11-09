package com.formation.orderservice.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateOrder(
        @NotBlank String costumer,
        @NotBlank String product,
        @NotBlank String email,
        @Min(1) int quantity
) { }
