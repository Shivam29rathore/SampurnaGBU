package com.cs.blogger.Model;

import android.graphics.drawable.Drawable;

public class NoticeBoardICt {

    String heading ;
    String discription;
    Drawable gradient;

    public NoticeBoardICt(String heading, String discription, Drawable gradient) {
        this.heading = heading;
        this.discription = discription;
        this.gradient = gradient;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public void setGradient(Drawable gradient) {
        this.gradient = gradient;
    }
}
