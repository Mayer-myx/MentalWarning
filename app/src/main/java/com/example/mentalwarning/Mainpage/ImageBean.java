package com.example.mentalwarning.Mainpage;

/**
 * @author Diredre
 * @brief description
 * @date 2022-03-09
 */
public class ImageBean {

    String url;

    public ImageBean(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "url='" + url + '\'' +
                '}';
    }
}
