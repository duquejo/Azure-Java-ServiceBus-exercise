/* (C)2023 */
package com.duquejo.servicebus;

import com.azure.spring.cloud.autoconfigure.implementation.jms.ServiceBusJmsAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = ServiceBusJmsAutoConfiguration.class)
public class ServicebusApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicebusApplication.class, args);
    }
}
