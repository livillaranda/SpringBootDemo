package com.revature.SpringBootDemo.models;

public class ClientMessage {

    private String message;

    public ClientMessage(String message) {
        super();
        this.message = message;
    }

    public ClientMessage() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}