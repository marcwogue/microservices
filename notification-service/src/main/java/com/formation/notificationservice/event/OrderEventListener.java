package com.formation.notificationservice.event;

import com.formation.notificationservice.service.EMailService;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    private static final Logger log = LoggerFactory.getLogger(OrderEventListener.class);

    @Autowired
    private EMailService eMailService;

    @KafkaListener(groupId = "notification-service", topics = "order.created22")
    public void OnOrderCreate(@NonNull CreateOrderEvent event){
        String emailBody = String.format(
                "Hello %s,\n\nYour order has been successfully created!\n\n" +
                        "Details:\n" +
                        "- Article: %s x %d\n" +
                        "- Date: %s\n\n" +
                        "Thank you for your purchase!",
                event.costumer(),
                event.product(),
                event.quantity(),
                event.createdAt()
        );
        eMailService.SendMail(event.email(), "order created", emailBody  );

        log.info("new order from costumer {} , ------ article: {} x {} ------ at ------ {} \n email : {}", event.costumer(), event.product(), event.quantity(), event.createdAt(), event.email());
    }
}
