package cn.iwenchaos.newsapp.module.welcome

import android.os.Bundle
import android.view.View
import cn.iwenchaos.newsapp.R
import cn.iwenchaos.newsapp.base.BaseNewsActivity
import cn.iwenchaos.newsapp.databinding.ActivitySplashBinding
import cn.iwenchaos.newsapp.utils.Router

/**
 * Created by:  awen on 2020/4/9  9:28 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :
 */
class SplashActivity : BaseNewsActivity<ActivitySplashBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle) {
        super.afterBindView(rootView, onSaveInstanceBundle)
        Router.toMain(this)
    }



}