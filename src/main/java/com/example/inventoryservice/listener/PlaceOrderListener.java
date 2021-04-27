package com.example.inventoryservice.listener;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class PlaceOrderListener {

    private final JmsTemplate jmsTemplate;

    private String PLACE_ORDER = "place_order";

    public PlaceOrderListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @Scheduled(fixedRate = 1000)
    public void listen() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(PLACE_ORDER);

        MessageConsumer consumer = session.createConsumer(destination);

        Message message = consumer.receive(1000);

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println("Received: " + text);
        } else {
            System.out.println("Received: " + message);
        }

        consumer.close();
        session.close();
        connection.close();
    }
}
