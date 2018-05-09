package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart

/**
 * Created by nightwingky on 17-3-19.
 */

class ShoppingCartListVO {

    var id: String? = null
    var seller: String? = null
    var title: String? = null
    var price: String? = null
    var location: String? = null

    constructor() {}

    constructor(id: String, seller: String,
                title: String, price: String, location: String) {
        this.id = id
        this.seller = seller
        this.title = title
        this.price = price
        this.location = location
    }

    override fun toString(): String {
        return "ShoppingCartListVO{" +
                "id='" + id + '\''.toString() +
                ", seller='" + seller + '\''.toString() +
                ", title='" + title + '\''.toString() +
                ", price='" + price + '\''.toString() +
                ", location='" + location + '\''.toString() +
                '}'.toString()
    }
}
