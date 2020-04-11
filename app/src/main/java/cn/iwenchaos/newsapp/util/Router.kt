package cn.iwenchaos.newsapp.util

import android.content.Context
import cn.iwenchaos.newsapp.module.main.MainActivity

/**
 * Created by:  awen on 2020/4/10  9:51 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
class Router {

    companion object{

        fun toMain(context: Context){
            MainActivity.start(context)
        }
    }

}