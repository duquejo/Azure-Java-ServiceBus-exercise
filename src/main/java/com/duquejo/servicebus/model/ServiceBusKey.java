/* (C)2023 */
package com.duquejo.servicebus.model;

/** The type Service bus key. */
public class ServiceBusKey {

    private final String host;
    private final String sharedAccessKeyName;
    private final String sharedAccessKey;

    /**
     * Instantiates a new Service bus key.
     *
     * @param host the host
     * @param sharedAccessKeyName the shared access key name
     * @param sharedAccessKey the shared access key
     */
    public ServiceBusKey(String host, String sharedAccessKeyName, String sharedAccessKey) {
        this.host = host;
        this.sharedAccessKeyName = sharedAccessKeyName;
        this.sharedAccessKey = sharedAccessKey;
    }

    /**
     * Gets host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Gets shared access key name.
     *
     * @return the shared access key name
     */
    public String getSharedAccessKeyName() {
        return sharedAccessKeyName;
    }

    /**
     * Gets shared access key.
     *
     * @return the shared access key
     */
    public String getSharedAccessKey() {
        return sharedAccessKey;
    }
}
