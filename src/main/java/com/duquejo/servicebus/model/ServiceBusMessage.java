/* (C)2023 */
package com.duquejo.servicebus.model;


/**
 * The type Service bus message.
 */
public class ServiceBusMessage {
    /**
     * The Id.
     */
    public String id;
    /**
     * The Type.
     */
    public String type;
    /**
     * The Content.
     */
    public String content;

    /**
     * Instantiates a new Service bus message.
     */
    public ServiceBusMessage() {}

    /**
     * Instantiates a new Service bus message.
     *
     * @param id      the id
     * @param type    the type
     * @param content the content
     */
    public ServiceBusMessage(String id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
