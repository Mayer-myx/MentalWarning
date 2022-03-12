package com.example.mentalwarning.Class;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-12
 */
public class ClassBean {

    private String imgurl;
    private String tit;
    private String con;

    public ClassBean(String imgurl, String tit, String con) {
        this.imgurl = imgurl;
        this.tit = tit;
        this.con = con;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }
}
