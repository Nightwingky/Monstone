package com.example.nightwingky.monstone.main_program.me.change_user_info;

/**
 * Created by nightwingky on 17-3-13.
 */

public class ChangeUserInfoVO {

    private String no;
    private String name;
    private int gender;
    private String birth;
    private String mobile;
    private String email;
    private String portrait;
    private String introduction;

    public ChangeUserInfoVO(String no, String name, int gender, String birth,
                            String mobile, String email, String portrait, String introduction) {
        this.no = no;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.mobile = mobile;
        this.email = email;
        this.portrait = portrait;
        this.introduction = introduction;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "ChangeUserInfoVO{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth='" + birth + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", portrait='" + portrait + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
