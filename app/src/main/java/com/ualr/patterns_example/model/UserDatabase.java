package com.ualr.patterns_example.model;

import java.util.HashMap;

/**
 * Created by irconde on 2019-09-10.
 */

// TODO 12: We define a Hashmap in order to retrieve users by id
public class UserDatabase {

    private HashMap<String, User> users;

    public UserDatabase() {
        this.users = new HashMap<>();
    }

    public void addUser(String id, String name) {
        this.users.put(id, new User(id, name));
    }

    public String getUser(String id) {
        try {
            return this.users.get(id).getName();
        } catch (NullPointerException e) {
            return "";
        }
    }
}
