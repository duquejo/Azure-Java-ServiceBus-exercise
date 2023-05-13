/* (C)2023 */
package com.duquejo.servicebus.controller;

import com.duquejo.servicebus.service.SendService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The type Send controller. */
@RestController
@RequestMapping(value = "v1/users")
public class SendController {

    private static final Logger logger = LoggerFactory.getLogger(SendController.class);

    @Autowired private SendService service;

    /** Instantiates a new Send controller. */
    public SendController() {}

    /**
     * Post message response entity.
     *
     * @return the response entity
     */
    @PostMapping("/topic")
    public ResponseEntity<String> postMessage() {
        return ResponseEntity.ok(service.sendMessage());
    }
}
