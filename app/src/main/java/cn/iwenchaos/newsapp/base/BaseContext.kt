package cn.iwenchaos.newsapp.base

import android.app.Application
import android.content.Context
import java.lang.IllegalArgumentException

/**
 * Created by:  awen on 2020/4/3  1:39 PM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
class BaseContext private constructor() {


    companion object {

        private var newsAppContext: NewsApp? = null

        fun setBaseContext(context: Context) {
            when (context) {
                is NewsApp -> {
                    newsAppContext = context;
                }
                else ->{
                    throw IllegalArgumentException("context could be Application context type")
                }
            }
        }

    }

}