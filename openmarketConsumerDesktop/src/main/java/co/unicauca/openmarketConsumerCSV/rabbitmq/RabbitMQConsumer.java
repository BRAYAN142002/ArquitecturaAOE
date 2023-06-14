package co.unicauca.openmarketConsumerCSV.rabbitmq;

import co.unicauca.openmarketConsumerCSV.constants.Constants;
import co.unicauca.openmarketConsumerCSV.domain.service.EventLogService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class RabbitMQConsumer {
    private final EventLogService eventService;

    public RabbitMQConsumer() {
        this.eventService = new EventLogService();
    }

    public void startConsuming(Channel channel) throws Exception {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            this.eventService.appendRow(this.eventService.parseMessage(message));
        };
        channel.basicConsume(Constants.QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}