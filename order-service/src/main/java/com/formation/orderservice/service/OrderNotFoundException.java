package com.formation.orderservice.service;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(UUID id) {
        super("commande non trouvéec: "+ id);
    }
}
