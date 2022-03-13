package com.example.mentalwarning.My;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-13
 */
public class InformBean {
    private String imgurl;
    private String name;
    private String con;
    private String time;
    private boolean isRead;

    public InformBean(String imgurl, String name, String con, String time, boolean isRead) {
        this.imgurl = imgurl;
        this.name = name;
        this.con = con;
        this.time = time;
        this.isRead = isRead;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
