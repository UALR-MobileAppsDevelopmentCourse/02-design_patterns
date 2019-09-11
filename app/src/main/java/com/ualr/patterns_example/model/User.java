package com.ualr.patterns_example.model;

/**
 * Created by irconde on 2019-09-10.
 */
public class User {

    // TODO 09: Defining attributes
    // TODO 10: Automatically create constructor, getter and setter methods with Generate...
    // TODO 11: Rearrange code

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
