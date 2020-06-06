package com.cs.blogger.Model;

public class eLearningHelper {

    String title;
    String desc;
    String downloadlink;

    public eLearningHelper(String title, String desc, String downloadlink) {
        this.title = title;
        this.desc = desc;
        this.downloadlink = downloadlink;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }
}
