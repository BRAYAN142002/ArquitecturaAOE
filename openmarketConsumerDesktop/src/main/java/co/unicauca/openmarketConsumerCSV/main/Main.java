package co.unicauca.openmarketConsumerCSV.main;

import co.unicauca.openmarketConsumerCSV.config.RabbitMQConfig;
import co.unicauca.openmarketConsumerCSV.rabbitmq.RabbitMQConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        RabbitMQConfig config = new RabbitMQConfig();

        ConnectionFactory factory = config.connectionFactory();
        Connection connection = config.connection(factory);
        Channel channel = config.channel(connection);

        RabbitMQConsumer consumer = new RabbitMQConsumer();
        consumer.startConsuming(channel);
    }
}