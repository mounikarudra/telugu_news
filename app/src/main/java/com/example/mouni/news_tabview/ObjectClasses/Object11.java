package com.example.mouni.news_tabview.ObjectClasses;

import java.io.Serializable;

/**
 * Created by MOUNI on 05-Aug-16.
 */
public class Object11 implements Serializable{

    public String title;
    public String content;
    public String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
