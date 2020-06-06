package com.cs.blogger.Model;

import android.graphics.drawable.Drawable;

public class NoticeboardICT {
    Drawable Gradient;
    String heading;
    String description;


    public NoticeboardICT(String heading, String description, Drawable gradient) {
        this.heading = heading;
        this.description = description;
        Gradient = gradient;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getGradient() {
        return Gradient;
    }

    public void setGradient(Drawable gradient) {
        Gradient = gradient;
    }
}
