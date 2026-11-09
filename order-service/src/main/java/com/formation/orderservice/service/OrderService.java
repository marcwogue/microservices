package com.formation.orderservice.service;


import com.formation.orderservice.api.dto.CreateOrder;
import com.formation.orderservice.api.dto.OrderResponse;
import com.formation.orderservice.domain.Order;
import com.formation.orderservice.event.CreateOrderEvent;
import com.formation.orderservice.event.OrderEventPublisher;
import com.formation.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private  final OrderEventPublisher orderEventPublisher;

    public OrderService(OrderRepository orderRepository, OrderEventPublisher orderEventPublisher) {
        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
    }

    @Transactional
    public OrderResponse createOrder(CreateOrder request){
        Order order = orderRepository.save(new Order(request.costumer(), request.product(), request.quantity(), request.email()));

        orderEventPublisher.publicOrderCreated(
                new CreateOrderEvent(
                        order.getId(),
                        order.getCostumer(),
                        order.getProduct(),
                        order.getCreateAt(),
                        order.getEmail(),
                        order.getQuantity()
                )
        );

        return  OrderResponse.from(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll (){
        return orderRepository.findAll().stream().map(OrderResponse::from).toList();
    }
    @Transactional(readOnly = true)
    public OrderResponse getById(String Id){
        UUID id = UUID.fromString(Id);

        return orderRepository.findById(id).map(OrderResponse::from)
                .orElseThrow(()-> new OrderNotFoundException(id));
    }
}
