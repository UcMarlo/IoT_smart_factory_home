package com.co.smart;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;

import javax.jms.*;


public class Producer {
    public static void produce(String message, String topic) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("ssl://b-61304742-9810-4b31-b2bd-fd2697e18319-1.mq.eu-west-3.amazonaws.com:61617");
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("NoszJaPi3rd0l3");

        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        pooledConnectionFactory.setMaxConnections(10);

        try {
            Connection producerConnection = pooledConnectionFactory.createConnection();
            producerConnection.start();

            Session producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination producerDestination = producerSession.createTopic(topic);

            MessageProducer producer = producerSession.createProducer(producerDestination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage producerMessage = producerSession.createTextMessage(message);
            producer.send(producerMessage);

            producer.close();
            producerSession.close();
            producerConnection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
