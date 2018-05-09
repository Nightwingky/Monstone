package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.freshList

/**
 * Created by nightwingky on 17-3-18.
 */

class FreshListItemVO(var product: String?, var seller: String?, var price: String?) {

    override fun toString(): String {
        return "FreshListItemVO{" +
                "product='" + product + '\''.toString() +
                ", seller='" + seller + '\''.toString() +
                ", price='" + price + '\''.toString() +
                '}'.toString()
    }
}
