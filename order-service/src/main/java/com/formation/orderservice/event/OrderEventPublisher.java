package com.formation.orderservice.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {

    public final static String TOPIC = "order.created22";
    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void  publicOrderCreated (CreateOrderEvent event){
        log.info("publishing ......");
        kafkaTemplate.send(TOPIC, event.id().toString(), event).thenRun(()->{
            log.info("publishing completed");
        } );
    }
}
