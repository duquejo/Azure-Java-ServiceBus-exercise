/* (C)2023 */
package com.duquejo.servicebus.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * The type Receiver component.
 */
@Component
public class ReceiverComponent {

    private final Logger logger = LoggerFactory.getLogger(ReceiverComponent.class);

    /**
     * Instantiates a new Receiver component.
     */
    public ReceiverComponent() {
    }

    /**
     * Receive message.
     *
     * @param message the message
     */
    @JmsListener(
            destination = "#{jmsConfig.getTopicName()}",
            containerFactory = "topicJmsListenerContainerFactory",
            subscription = "#{jmsConfig.getSubscriptionName()}")
    public void receiveMessage(String message) {
        logger.info("Received message: {}", message);
    }
}
