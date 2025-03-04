package com.orderManager.orderProducer.controller;

import com.orderManager.orderProducer.Entity.Order;
import com.orderManager.orderProducer.service.OrderProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderProducerService orderProducerService;

    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderProducerService.sendOrder(order);
        return "Order sent successfully!";
    }
}