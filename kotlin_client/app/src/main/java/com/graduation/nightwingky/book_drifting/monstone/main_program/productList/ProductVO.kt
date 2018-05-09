package com.graduation.nightwingky.book_drifting.monstone.main_program.productList

/**
 * Created by nightwingky on 17-3-19.
 */

class ProductVO {

    var name: String? = null
    var seller: String? = null
    var price: String? = null
    var catalog: String? = null
    var introduction: String? = null
    var location: String? = null
    var releaseTime: String? = null
    var productId: String? = null

    constructor() {}

    constructor(name: String, seller: String, price: String, catalog: String, introduction: String,
                location: String, releaseTime: String, productId: String) {
        this.name = name
        this.seller = seller
        this.price = price
        this.catalog = catalog
        this.introduction = introduction
        this.location = location
        this.releaseTime = releaseTime
        this.productId = productId
    }

    override fun toString(): String {
        return "ProductVO{" +
                "name='" + name + '\''.toString() +
                ", seller='" + seller + '\''.toString() +
                ", price='" + price + '\''.toString() +
                ", catalog='" + catalog + '\''.toString() +
                ", introduction='" + introduction + '\''.toString() +
                ", location='" + location + '\''.toString() +
                ", releaseTime='" + releaseTime + '\''.toString() +
                '}'.toString()
    }
}
