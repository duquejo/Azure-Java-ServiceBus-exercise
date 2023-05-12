/* (C)2023 */
package com.duquejo.servicebus;

import com.azure.spring.cloud.autoconfigure.implementation.jms.ServiceBusJmsAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * The type Servicebus application.
 */
@SpringBootApplication(exclude = ServiceBusJmsAutoConfiguration.class)
public class ServicebusApplication {

    /**
     * Instantiates a new Servicebus application.
     */
    public ServicebusApplication() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServicebusApplication.class, args);
    }
}
