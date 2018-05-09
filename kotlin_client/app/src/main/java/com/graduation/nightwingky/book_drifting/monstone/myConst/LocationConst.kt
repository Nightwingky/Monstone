package com.graduation.nightwingky.book_drifting.monstone.myConst

import com.graduation.nightwingky.book_drifting.monstone.myConst.LocationConst.mLoc
import java.util.Random

/**
 * Created by nightwingky on 17-3-19.
 */

object LocationConst {

    private val mLoc = arrayOf("来自：北京 海淀 清华东路35号 北京林业大学", "来自：北京 海淀 双清路30号 清华大学", "来自：北京 海淀 颐和园路5号 北京大学", "来自：北京 海淀 清华东路17号 中国农业大学（东校区）")

    val randomLoc: String
        get() {
            val random = Random()

            return mLoc[random.nextInt(mLoc.size)]
        }
}
