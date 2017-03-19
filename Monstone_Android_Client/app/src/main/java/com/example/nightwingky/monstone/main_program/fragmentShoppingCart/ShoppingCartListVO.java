package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ShoppingCartListVO {

    private String seller;
    private String title;
    private String price;
    private String location;

    public ShoppingCartListVO(String seller, String title, String price, String location) {
        this.seller = seller;
        this.title = title;
        this.price = price;
        this.location = location;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ShoppingCartListVO{" +
                "seller='" + seller + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
