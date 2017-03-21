package com.example.nightwingky.monstone.myConst;

/**
 * Created by nightwingky on 17-3-12.
 */

public class URLConst {

    private static String user_id = "";

    private static final String user_login_url = "http://118.228.180.248:8080/api/user/login/common";

    private static final String user_change_info_url = "http://118.228.180.248:8080/api/user/setting/detail";

    private static final String user_change_name_url = "http://118.228.180.248:8080/api/user/setting/name";

    private static final String user_change_gender_url = "http://118.228.180.248:8080/api/user/setting/gender";

    private static final String user_change_mobile_url = "http://118.228.180.248:8080/api/user/setting/mobile";

    private static final String user_put_out_url = "http://118.228.180.248:8080/api/product/release";

    private static final String product_info_detail_url = "http://118.228.180.248:8080/api/product/setting/baseinfo";

    private static final String search_product_list_url = "http://118.228.180.248:8080/api/product/search/normal";

    private static final String get_content_from_shopping_cart_url = "http://118.228.180.248:8080/api/cart/query";

    private static final String add_to_shopping_cart = "http://118.228.180.248:8080/api/cart/modify";

    public static void setUser_id(String user_id) {
        URLConst.user_id = user_id;
    }

    public static String getUser_id() {
        return user_id;
    }

    public static String getUser_login_url() {
        return user_login_url;
    }

    public static String getUser_change_info_url() {
        return user_change_info_url;
    }

    public static String getUser_change_name_url() {
        return user_change_name_url;
    }

    public static String getUser_change_gender_url() {
        return user_change_gender_url;
    }

    public static String getUser_change_mobile_url() {
        return user_change_mobile_url;
    }

    public static String getUser_put_out_url() {
        return user_put_out_url;
    }

    public static String getProduct_info_detail_url() {
        return product_info_detail_url;
    }

    public static String getSearch_product_list_url() {
        return search_product_list_url;
    }

    public static String getGet_content_from_shopping_cart_url() {
        return get_content_from_shopping_cart_url;
    }

    public static String getAdd_to_shopping_cart() {
        return add_to_shopping_cart;
    }
}
