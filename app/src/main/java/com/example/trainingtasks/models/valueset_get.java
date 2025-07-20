package com.example.trainingtasks.models;

public class valueset_get {
    int picture;
    String txt;

    public valueset_get(int picture, String txt) {
        this.picture=picture;
        this.txt=txt;
    }



    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }


}

