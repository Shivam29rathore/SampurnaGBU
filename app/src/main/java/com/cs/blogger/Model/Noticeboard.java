package com.cs.blogger.Model;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class Noticeboard {

    int image;
    String title, description;

    public Noticeboard(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}