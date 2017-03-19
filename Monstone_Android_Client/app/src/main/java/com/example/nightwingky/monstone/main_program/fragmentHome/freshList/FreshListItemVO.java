package com.example.nightwingky.monstone.main_program.fragmentHome.freshList;

/**
 * Created by nightwingky on 17-3-18.
 */

public class FreshListItemVO {

    private String product;
    private String seller;
    private String price;

    public FreshListItemVO(String product, String seller, String price) {
        this.product = product;
        this.seller = seller;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    @Override
    public String toString() {
        return "FreshListItemVO{" +
                "product='" + product + '\'' +
                ", seller='" + seller + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
