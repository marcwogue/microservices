package com.formation.notificationservice.event;

import java.time.Instant;
import java.util.UUID;

public record CreateOrderEvent (
        UUID id,
        String costumer,
        String product,
        Instant createdAt ,
        String email,
        int quantity
) { }
