package com.graduation.nightwingky.book_drifting.monstone.myConst

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.freshList.FreshListItemVO
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.itemList.ItemListGridVO
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.titleBar.TitleBarGridVO

import java.util.ArrayList

/**
 * Created by nightwingky on 17-3-18.
 */

object HomeConst {

    var titleSource = intArrayOf(R.drawable.titlebar1, R.drawable.titlebar2, R.drawable.titlebar3, R.drawable.titlebar4)

    var itemListSource = intArrayOf(R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item6)

    var imgSrc = intArrayOf(R.drawable.iphone1, R.drawable.iphone2, R.drawable.iphone3, R.drawable.iphone5, R.drawable.mi1, R.drawable.mi2, R.drawable.mi3, R.drawable.samsung1, R.drawable.samsang2, R.drawable.samsung3)

    val flipper: List<Any>
        get() {
            val mList = ArrayList<Any>()
            mList.add(1)

            return mList
        }

    val titleBar: List<TitleBarGridVO>
        get() {
            val mList = ArrayList<TitleBarGridVO>()

            mList.add(TitleBarGridVO(
                    "精选",
                    "这里有好东西",
                    titleSource[0]
            ))
            mList.add(TitleBarGridVO(
                    "拍卖",
                    "1元起拍捡漏",
                    titleSource[1]
            ))
            mList.add(TitleBarGridVO(
                    "校园",
                    "选闲置更靠谱",
                    titleSource[2]
            ))
            mList.add(TitleBarGridVO(
                    "推荐",
                    "你可能喜欢的",
                    titleSource[3]
            ))

            return mList
        }

    val divide: List<Any>
        get() {
            val mList = ArrayList<Any>()
            mList.add(1)

            return mList
        }

    val item: List<ItemListGridVO>
        get() {
            val mList = ArrayList<ItemListGridVO>()

            mList.add(ItemListGridVO(
                    "小米",
                    "122个新宝贝上线",
                    itemListSource[1]
            ))
            mList.add(ItemListGridVO(
                    "华为荣耀",
                    "36个新宝贝上线",
                    itemListSource[2]
            ))
            mList.add(ItemListGridVO(
                    "穿搭",
                    "今日实拍已上新",
                    itemListSource[3]
            ))
            mList.add(ItemListGridVO(
                    "奇货",
                    "每日上新20件，件件新奇",
                    itemListSource[4]
            ))
            mList.add(ItemListGridVO(
                    "[技能]外语",
                    "外教一对一，英语轻松学",
                    itemListSource[5]
            ))
            mList.add(ItemListGridVO(
                    "线下面对面",
                    "89个新宝贝上线",
                    itemListSource[0]
            ))

            return mList
        }

    val fresh: List<Any>
        get() {
            val mList = ArrayList<Any>()
            mList.add(1)

            return mList
        }

    val freshListItemVOList: List<FreshListItemVO>
        get() {
            val mList = ArrayList<FreshListItemVO>()

            mList.add(FreshListItemVO(
                    "小米5s 4+128G 高配全网通双卡移动联通电信手机 外壳有轻微磕碰 功能正常",
                    "queky1024",
                    "￥1599.00"
            ))
            mList.add(FreshListItemVO(
                    "s7edge，外观近全新，32g，支持拓展内存卡，蝙蝠侠国行系统，单卡三网4g，没拆修",
                    "queky1024",
                    "￥2299.00"
            ))
            mList.add(FreshListItemVO(
                    "魅族mx4pro手机成色9成新白色3+16g2070万像素5.5英寸移动联通4g支持指纹解锁外观9成新",
                    "queky1024",
                    "￥500.00"
            ))

            return mList
        }
}
