package com.co.smart;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Consumer {

    public static void consume() {

        ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory("ssl://b-61304742-9810-4b31-b2bd-fd2697e18319-1.mq.eu-west-3.amazonaws.com:61617");

        connFactory.setUserName("admin");
        connFactory.setPassword("NoszJaPi3rd0l3");

        try {
            Connection consumerConn = connFactory.createConnection();
            consumerConn.start();

            Session consumerSession = consumerConn.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination consumerDest = consumerSession.createTopic("NewTopic");

            MessageConsumer consumer = consumerSession.createConsumer(consumerDest);

            consumer.setMessageListener(new ConsumerMessageListener());

            Thread.sleep(50000);
            consumer.close();
            consumerSession.close();
            consumerConn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
