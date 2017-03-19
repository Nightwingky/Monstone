package com.example.nightwingky.monstone.main_program.productList;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ProductVO {

    private String name;
    private String seller;
    private String price;
    private String catalog;
    private String introduction;
    private String location;
    private String releaseTime;

    public ProductVO() {
    }

    public ProductVO(String name, String seller, String price, String catalog,
                     String introduction, String location, String releaseTime) {
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.catalog = catalog;
        this.introduction = introduction;
        this.location = location;
        this.releaseTime = releaseTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "name='" + name + '\'' +
                ", seller='" + seller + '\'' +
                ", price='" + price + '\'' +
                ", catalog='" + catalog + '\'' +
                ", introduction='" + introduction + '\'' +
                ", location='" + location + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                '}';
    }
}
