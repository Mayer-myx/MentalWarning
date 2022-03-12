package com.example.mentalwarning.Mainpage;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-10
 */
public class TeachBean {
    private String name;
    private String like;
    private String intro;
    private String picurl;

    public TeachBean(String name, String like, String intro, String picurl) {
        this.name = name;
        this.like = like;
        this.intro = intro;
        this.picurl = picurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
