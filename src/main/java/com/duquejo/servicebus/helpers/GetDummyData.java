/* (C)2023 */
package com.duquejo.servicebus.helpers;

import com.duquejo.servicebus.model.User;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Get dummy data.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GetDummyData {


    /**
     * Instantiates a new Get dummy data.
     */
    public GetDummyData() {
    }

    /**
     * Gets dummy users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        ArrayList<User> usersList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            usersList.add(new User(i, String.format("User%s", i)));
        }
        return usersList;
    }
}
