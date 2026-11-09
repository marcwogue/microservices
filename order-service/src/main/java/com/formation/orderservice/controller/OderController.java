package com.formation.orderservice.controller;

import com.formation.orderservice.api.dto.CreateOrder;
import com.formation.orderservice.api.dto.OrderResponse;
import com.formation.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OderController {

    private final OrderService orderService;

    public OderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ORDER_CREATE')")
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrder order){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }
    @GetMapping
    @PreAuthorize("hasRole('ORDER_READ')")
    public ResponseEntity<List<OrderResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ORDER_VIEW')")
    public ResponseEntity<OrderResponse> getById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getById(id));
    }
}
