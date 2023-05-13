/* (C)2023 */
package com.duquejo.servicebus.config;

import com.duquejo.servicebus.helpers.ConnectionStringResolver;
import com.duquejo.servicebus.model.ServiceBusKey;

import jakarta.jms.ConnectionFactory;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

/** The type Jms config. */
@Configuration
public class JmsConfig {

    @Value("${azure.servicebus.connection-string}")
    private String connectionString;

    @Value("${azure.servicebus.topic-client-id}")
    private String clientId = "";

    @Value("${azure.servicebus.topic-subscription-name}")
    private String subscriptionName;

    @Value("${azure.servicebus.idle-timeout}")
    private int idleTimeout;

    private static final String AMQP_URI_FORMAT = "amqps://%s?amqp.idleTimeout=%d";

    /** Instantiates a new Jms config. */
    public JmsConfig() {}

    /**
     * Gets topic name.
     *
     * @return the topic name
     */
    public String getTopicName() {
        return clientId;
    }

    /**
     * Gets subscription name.
     *
     * @return the subscription name
     */
    public String getSubscriptionName() {
        return subscriptionName;
    }

    /**
     * Connection factory.
     *
     * @return the connection factory
     */
    @Bean
    public ConnectionFactory connectionFactory() {

        ServiceBusKey serviceBusKey = ConnectionStringResolver.getServiceBusKey(connectionString);
        String host = serviceBusKey.getHost();
        String sasKeyName = serviceBusKey.getSharedAccessKeyName();
        String sasKey = serviceBusKey.getSharedAccessKey();

        String remoteUrl = String.format(AMQP_URI_FORMAT, host, idleTimeout);

        JmsConnectionFactory jmsConnectionFactory = new JmsConnectionFactory();
        jmsConnectionFactory.setRemoteURI(remoteUrl);
        jmsConnectionFactory.setClientID(clientId);
        jmsConnectionFactory.setUsername(sasKeyName);
        jmsConnectionFactory.setPassword(sasKey);

        return new CachingConnectionFactory(jmsConnectionFactory);
    }

    /**
     * Topic jms listener container factory.
     *
     * @param connectionFactory the connection factory
     * @return the jms listener container factory
     */
    @Bean
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(
            ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory topicFactory = new DefaultJmsListenerContainerFactory();
        topicFactory.setConnectionFactory(connectionFactory);
        topicFactory.setSubscriptionDurable(Boolean.TRUE);
        return topicFactory;
    }
}
