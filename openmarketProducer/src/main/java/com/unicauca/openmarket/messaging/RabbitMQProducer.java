package com.unicauca.openmarket.messaging;

import com.unicauca.openmarket.messaging.ProductMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${openmarket.rabbitmq.queue}")
    private String queueName;

    public void send(ProductMessage message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}