package cn.iwenchaos.newsapp.module.welcome

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import cn.iwenchaos.newsapp.R
import cn.iwenchaos.newsapp.base.BaseNewsActivity
import cn.iwenchaos.newsapp.databinding.ActivitySplashBinding
import cn.iwenchaos.newsapp.module.welcome.listener.LocalAnimatorListener
import cn.iwenchaos.newsapp.util.Router
import cn.iwenchaos.newsapp.util.permission.PermissionUtil
import cn.iwenchaos.newsapp.util.permission.PermissionUtil.Companion.BASE_PERMISSIONS
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Created by:  awen on 2020/4/9  9:28 AM
 * email     :  liuwenchao@mockuai.com
 * Describe  :  欢迎页
 */
class SplashActivity : BaseNewsActivity<ActivitySplashBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun beforeOnCreate(savedInstanceState: Bundle?) {
        super.beforeOnCreate(savedInstanceState)
        val lacks = PermissionUtil.checkPermissions(this, BASE_PERMISSIONS)
        lacks.takeIf { lacks.isNotEmpty() }.run {
            PermissionUtil.requestPermissions(this@SplashActivity, lacks.toTypedArray())
        }

    }

    override fun afterBindView(rootView: View?, onSaveInstanceBundle: Bundle?) {
        super.afterBindView(rootView, onSaveInstanceBundle)
        toMainAfterAnimator()
    }

    private fun toMainAfterAnimator() {
        lavAnimation.run {
            this.playAnimation()
            this.addAnimatorListener(object : LocalAnimatorListener {
                override fun onAnimationEnd(animation: Animator?) {
                    lavAnimation.clearAnimation()
                    Router.toMain(this@SplashActivity)
                    finish()
                }
            })
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

}