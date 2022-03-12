package com.example.mentalwarning.Mainpage;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-10
 */
public class MessageBean {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int type;

    public MessageBean(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

}