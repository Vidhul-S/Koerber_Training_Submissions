package com.orderManager.orderConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.orderManager.orderConsumer.Entity.Order;

@Service
public class OrderConsumerService {
    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void consumeOrder(Order order) {
        System.out.println("Order received: " + order);
        System.out.println("Processing order...");
    }
}
