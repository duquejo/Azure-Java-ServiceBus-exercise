/* (C)2023 */
package com.duquejo.servicebus.model;

public class ServiceBusKey {

    private final String host;
    private final String sharedAccessKeyName;
    private final String sharedAccessKey;

    public ServiceBusKey(String host, String sharedAccessKeyName, String sharedAccessKey) {
        this.host = host;
        this.sharedAccessKeyName = sharedAccessKeyName;
        this.sharedAccessKey = sharedAccessKey;
    }

    public String getHost() {
        return host;
    }

    public String getSharedAccessKeyName() {
        return sharedAccessKeyName;
    }

    public String getSharedAccessKey() {
        return sharedAccessKey;
    }
}
