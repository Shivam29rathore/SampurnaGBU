package com.cs.blogger.Model;

public class ResultsHelper {

    String title;
    String description;
    String downloadlink;

    public ResultsHelper(String title, String description, String downloadlink) {
        this.title = title;
        this.description = description;
        this.downloadlink = downloadlink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink;
    }
}

