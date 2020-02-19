package com.ualr.patterns_example.model;

/**
 * Created by irconde on 2019-09-10.
 */

// TODO 02: Create inside the new package a class that represents a very simple User: just and id and a name

public class User {

    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
