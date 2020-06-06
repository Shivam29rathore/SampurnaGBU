package com.cs.blogger.Model;

/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */

public class MostViewed {

    int imageView;
    String textView;

    public MostViewed(int imageView, String textView) {
        this.imageView = imageView;
        this.textView = textView;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTextView() {
        return textView;
    }

}
