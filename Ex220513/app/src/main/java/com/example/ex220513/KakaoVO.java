package com.example.ex220513;

import android.graphics.drawable.Drawable;

public class KakaoVO {

    private Drawable img;
    private String name;
    private String msg;
    private String music;

    @Override
    public String toString() {
        return "KakaoVO{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", music='" + music + '\'' +
                '}';
    }

    public KakaoVO() {

    }

    public KakaoVO(Drawable img, String name, String msg, String music) {
        this.img = img;
        this.name = name;
        this.msg = msg;
        this.music = music;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
