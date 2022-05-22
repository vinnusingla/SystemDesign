package com.vinayak.practice.model;

public class Player {
    private String name;
    private String userName;
    // details for player

    public Player(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
