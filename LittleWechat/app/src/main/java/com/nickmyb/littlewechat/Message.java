package com.nickmyb.littlewechat;

public class Message {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENDED = 1;

    private String message;
    private int type;

    public Message(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public int getType() {
        return type;
    }
}
