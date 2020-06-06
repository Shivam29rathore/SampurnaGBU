package com.cs.blogger.Model;

import android.graphics.drawable.Drawable;
/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class Categories {

    Drawable gradient;
    int image;
    String titile;

    public Categories(Drawable gradient, int image, String titile) {
        this.gradient = gradient;
        this.image = image;
        this.titile = titile;
    }

    public Drawable getGradient() {
        return gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitile() {
        return titile;
    }
}
