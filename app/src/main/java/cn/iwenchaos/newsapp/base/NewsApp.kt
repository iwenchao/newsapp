package cn.iwenchaos.newsapp.base

import android.app.Application
import android.content.Context

/**
 * Created by:  awen on 2020/4/3  1:38 PM
 * email     :  liuwenchao@gmail.com
 * Describe  :
 */

class NewsApp : Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        BaseContext.setBaseContext(this)
    }

    override fun onCreate() {
        super.onCreate()

    }

}


