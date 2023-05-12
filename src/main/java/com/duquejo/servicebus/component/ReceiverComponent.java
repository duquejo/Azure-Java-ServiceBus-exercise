/* (C)2023 */
package com.duquejo.servicebus.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverComponent {

    private final Logger logger = LoggerFactory.getLogger(ReceiverComponent.class);

    @JmsListener(
            destination = "#{jmsConfig.getTopicName()}",
            containerFactory = "topicJmsListenerContainerFactory",
            subscription = "#{jmsConfig.getSubscriptionName()}")
    public void receiveMessage(String message) {
        logger.info("Received message: {}", message);
    }
}
