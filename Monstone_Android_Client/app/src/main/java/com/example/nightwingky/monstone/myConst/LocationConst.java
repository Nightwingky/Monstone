package com.example.nightwingky.monstone.myConst;

import java.util.Random;

/**
 * Created by nightwingky on 17-3-19.
 */

public class LocationConst {

    private static String[] mLoc = {
            "来自：北京 海淀 清华东路35号 北京林业大学",
            "来自：北京 海淀 双清路30号 清华大学",
            "来自：北京 海淀 颐和园路5号 北京大学",
            "来自：北京 海淀 清华东路17号 中国农业大学（东校区）"
    };

    public static String getRandomLoc() {
        Random random = new Random();
        String s = mLoc[random.nextInt(mLoc.length)];

        return s;
    }
}
