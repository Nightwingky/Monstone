package com.example.nightwingky.monstone.main_program.home.homeConst;

import com.example.nightwingky.monstone.main_program.home.freshList.FreshListItemVO;
import com.example.nightwingky.monstone.main_program.home.itemList.ItemListGridVO;
import com.example.nightwingky.monstone.main_program.home.titleBar.TitleBarGridVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nightwingky on 17-3-18.
 */

public class HomeConst {

    public static List<Object> getFlipper() {
        List<Object> mList = new ArrayList<>();
        mList.add(1);

        return mList;
    }

    public static List<TitleBarGridVO> getTitleBar() {
        List<TitleBarGridVO> mList = new ArrayList<>();

        mList.add(new TitleBarGridVO(
                "精选",
                "这里有好东西",
                1
        ));
        mList.add(new TitleBarGridVO(
                "拍卖",
                "1元起拍捡漏",
                1
        ));
        mList.add(new TitleBarGridVO(
                "校园",
                "选闲置更靠谱",
                1
        ));
        mList.add(new TitleBarGridVO(
                "推荐",
                "你可能喜欢的",
                1
        ));

        return mList;
    }

    public static List<Object> getDivide() {
        List<Object> mList = new ArrayList<>();
        mList.add(1);

        return mList;
    }

    public static List<ItemListGridVO> getItem() {
        List<ItemListGridVO> mList = new ArrayList<>();

        mList.add(new ItemListGridVO(
                "小米",
                "122个新宝贝上线",
                1
        ));
        mList.add(new ItemListGridVO(
                "华为荣耀",
                "36个新宝贝上线",
                1
        ));
        mList.add(new ItemListGridVO(
                "穿搭",
                "今日实拍已上新",
                1
        ));
        mList.add(new ItemListGridVO(
                "奇货",
                "每日上新20件，件件新奇",
                1
        ));
        mList.add(new ItemListGridVO(
                "[技能]外语",
                "外教一对一，英语轻松学",
                1
        ));
        mList.add(new ItemListGridVO(
                "线下面对面",
                "89个新宝贝上线",
                1
        ));

        return mList;
    }

    public static List<Object> getFresh() {
        List<Object> mList = new ArrayList<>();
        mList.add(1);

        return mList;
    }

    public static List<FreshListItemVO> getFreshListItemVOList() {
        List<FreshListItemVO> mList = new ArrayList<>();

        mList.add(new FreshListItemVO(
                "小米5s 4+128G 高配全网通双卡移动联通电信手机 外壳有轻微磕碰 功能正常",
                "queky1024",
                "￥1599.00"
        ));
        mList.add(new FreshListItemVO(
                "s7edge，外观近全新，32g，支持拓展内存卡，蝙蝠侠国行系统，单卡三网4g，没拆修",
                "queky1024",
                "￥2299.00"
        ));
        mList.add(new FreshListItemVO(
                "魅族mx4pro手机成色9成新白色3+16g2070万像素5.5英寸移动联通4g支持指纹解锁外观9成新",
                "queky1024",
                "￥500.00"
        ));

        return mList;
    }
}
