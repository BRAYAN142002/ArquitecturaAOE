package co.unicauca.openmarketConsumerCSV.main;

import co.unicauca.openmarketConsumerCSV.domain.service.RabbitMQConsumer;

public class OpenMarketCSV {
    public static void main(String[] args) throws Exception {
        RabbitMQConsumer consumer = new RabbitMQConsumer();
        consumer.startConsuming();
    }
}