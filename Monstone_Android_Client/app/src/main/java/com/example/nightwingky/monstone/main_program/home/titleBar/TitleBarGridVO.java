package com.example.nightwingky.monstone.main_program.home.titleBar;

/**
 * Created by nightwingky on 17-3-18.
 */

public class TitleBarGridVO {

    private String title;
    private String introduction;
    private int imgSrc;

    public TitleBarGridVO() {
    }

    public TitleBarGridVO(String title, String introduction, int imgSrc) {
        this.title = title;
        this.introduction = introduction;
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    @Override
    public String toString() {
        return "TitleBarGridVO{" +
                "title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", imgSrc=" + imgSrc +
                '}';
    }
}
