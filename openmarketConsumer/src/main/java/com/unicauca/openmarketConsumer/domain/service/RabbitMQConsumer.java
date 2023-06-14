
package com.unicauca.openmarketConsumer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unicauca.openMarketConsumer.config.RabbitMQConfig;
import com.unicauca.openmarketConsumer.domain.entity.Product;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQConsumer {
    @Autowired
    IProductEventService productLogService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consumeMessageFromQueue(String message) {
        System.out.println("Message recieved from queue : " + message);
        Product product = new Product();
        String[] parts = message.split(",");
        if (parts.length == 4) {
            try {
                product.setId(Long.parseLong(parts[0]));
                product.setName(parts[1]);
                product.setPrice(Double.parseDouble(parts[2]));
                product.setAction(parts[3]);
                productLogService.create(product);
            } catch (Exception e) {
                throw new AmqpRejectAndDontRequeueException(e);
            }
        }
    }
}