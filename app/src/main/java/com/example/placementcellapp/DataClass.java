package com.example.placementcellapp;

public class DataClass {
    private String dataTitle;
    private int dataDesc;
    private String dataPost;
    private int dataImage;

    public DataClass(String dataTitle, int dataDesc, String dataPost, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataPost = dataPost;
        this.dataImage = dataImage;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataPost() {
        return dataPost;
    }

    public int getDataImage() {
        return dataImage;
    }
}
