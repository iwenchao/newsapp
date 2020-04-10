package cn.iwenchaos.newsapp.module.welcome

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import cn.iwenchaos.newsapp.R
import cn.iwenchaos.newsapp.base.BaseNewsActivity
import cn.iwenchaos.newsapp.databinding.ActivitySplashBinding
import cn.iwenchaos.newsapp.module.welcome.listener.LocalAnimatorListener
import cn.iwenchaos.newsapp.utils.Router
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by:  awen on 2020/4/9  9:28 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  欢迎页
 */
class SplashActivity : BaseNewsActivity<ActivitySplashBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle?) {
        super.afterBindView(rootView, onSaveInstanceBundle)
        toMainAfterAnimator()
    }

    private fun toMainAfterAnimator() {
        lavAnimation.run {
            this.addAnimatorListener(object : LocalAnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                    lavAnimation.clearAnimation()
                    Router.toMain(this@SplashActivity)
                }
            })
        }
    }


}