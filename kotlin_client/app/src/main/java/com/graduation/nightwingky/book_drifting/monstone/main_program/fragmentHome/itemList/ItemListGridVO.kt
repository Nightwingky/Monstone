package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.itemList

/**
 * Created by nightwingky on 17-3-18.
 */

class ItemListGridVO {

    var title: String? = null
    var introduction: String? = null
    var imgSrc: Int = 0

    constructor(title: String, introduction: String, imgSrc: Int) {
        this.title = title
        this.introduction = introduction
        this.imgSrc = imgSrc
    }

    override fun toString(): String {
        return "ItemListGridVO{" +
                "title='" + title + '\''.toString() +
                ", introduction='" + introduction + '\''.toString() +
                ", imgSrc=" + imgSrc +
                '}'.toString()
    }
}
