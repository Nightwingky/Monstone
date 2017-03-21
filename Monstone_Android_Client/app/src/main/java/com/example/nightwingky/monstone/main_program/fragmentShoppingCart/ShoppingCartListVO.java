package com.example.nightwingky.monstone.main_program.fragmentShoppingCart;

/**
 * Created by nightwingky on 17-3-19.
 */

public class ShoppingCartListVO {

    private String id;
    private String seller;
    private String title;
    private String price;
    private String location;

    public ShoppingCartListVO() {
    }

    public ShoppingCartListVO(String id, String seller,
                              String title, String price, String location) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShoppingCartListVO{" +
                "id='" + id + '\'' +
                ", seller='" + seller + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
