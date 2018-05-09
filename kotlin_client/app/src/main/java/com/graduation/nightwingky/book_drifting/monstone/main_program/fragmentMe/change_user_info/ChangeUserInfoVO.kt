package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.change_user_info

/**
 * Created by nightwingky on 17-3-13.
 */

class ChangeUserInfoVO(var no: String?, var name: String?, var gender: Int, var birth: String?,
                       var mobile: String?, var email: String?, var portrait: String?, var introduction: String?) {

    override fun toString(): String {
        return "ChangeUserInfoVO{" +
                "no='" + no + '\''.toString() +
                ", name='" + name + '\''.toString() +
                ", gender=" + gender +
                ", birth='" + birth + '\''.toString() +
                ", mobile=" + mobile +
                ", email='" + email + '\''.toString() +
                ", portrait='" + portrait + '\''.toString() +
                ", introduction='" + introduction + '\''.toString() +
                '}'.toString()
    }
}
