/* (C)2023 */
package com.duquejo.servicebus.service;

import com.duquejo.servicebus.config.JmsConfig;
import com.duquejo.servicebus.helpers.GetDummyData;
import com.duquejo.servicebus.model.ServiceBusMessage;
import com.duquejo.servicebus.model.User;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * The type Send service.
 */
@Service
public class SendServiceImpl implements SendService {

    private static final Logger logger = LoggerFactory.getLogger(SendServiceImpl.class);
    private final Gson gson = new Gson();

    @Autowired private JmsConfig jmsConfig;

    @Autowired private GetDummyData dummyData;

    @Autowired private JmsTemplate jmsTemplate;

    /**
     * Instantiates a new Send service.
     */
    public SendServiceImpl() {
    }

    @Override
    public String sendMessage() {
        logger.info("Sending message...");
        List<User> users = dummyData.getUsers();

        String serializedUsers = gson.toJson(users);
        String messageId = UUID.randomUUID().toString();
        String messageType = "userData";
        String topicName = jmsConfig.getTopicName();

        ServiceBusMessage message = new ServiceBusMessage(messageId, messageType, serializedUsers);

        String serializedObject = gson.toJson(message);

        // Send data to bus.
        logger.debug("Logging {} {}", topicName, serializedObject);
        jmsTemplate.convertAndSend(topicName, serializedObject);
        logger.info("Message sent!..");
        return serializedObject;
    }
}
